package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Mood;
import com.oopa.domain.model.Plantmood;
import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantmoodService {

    @Autowired
    private MqttService mqttService;
    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PlantmoodRepository plantmoodRepository;
    @Autowired
    private PlantmoodHistoryRepository plantmoodHistoryRepository;

    private String mood;
    private static Logger logger = LoggerFactory.getLogger(PlantmoodService.class);

    public Plantmood addPlantmood(Plantmood plantmood) {
        var plantmoodEntity = this.modelMapper.map(plantmood, com.oopa.dataAccess.model.Plantmood.class);
        return this.modelMapper.map(plantmoodRepository.save(plantmoodEntity), Plantmood.class);
    }

    public void getPlantStatus(String arduinoSn) {
        List<IPlantmoodhistory> plantmoodhistories = plantmoodHistoryService.getAllHistoryByArduinoSn(arduinoSn);
        IPlantmood currentPlantmood = plantmoodRepository.findByArduinoSn(arduinoSn);

        double avarageOfPlantmoodData = calculateAverageHistory(plantmoodhistories);

        decideMood(avarageOfPlantmoodData,currentPlantmood);
    }

    public double calculateAverageHistory(List<IPlantmoodhistory> plantmoodhistories){
        double average = 0;
        if (plantmoodhistories.size() > 4 ) {
            List<IPlantmoodhistory> subListPlantmoodhistories = getSublistOfHistory(plantmoodhistories);
            average = averageHistory(subListPlantmoodhistories);
        }
        return average;
    }

    public double averageHistory(List<IPlantmoodhistory> subListPlantmoodhistories){
        double valueOfPlantmoodData = 0;
        double multiplier = 1;
        double substractionOfAverage = 0;

        for (IPlantmoodhistory history: subListPlantmoodhistories) {
            valueOfPlantmoodData += multiplier * history.getHealth();
            substractionOfAverage += multiplier;
            multiplier -= 0.2;
        }
        return valueOfPlantmoodData / substractionOfAverage;
    }

    public List<IPlantmoodhistory> getSublistOfHistory(List<IPlantmoodhistory> plantmoodhistories){
        return plantmoodhistories.stream()
                .sorted(Comparator.comparing(IPlantmoodhistory::getCreatedAt).reversed())
                .collect(Collectors.toList()).subList(0, 5);
    }

    public void decideMood(double avarageOfPlantmoodData, IPlantmood currentPlantmood){
        if (avarageOfPlantmoodData < currentPlantmood.getPlantSpecies().getMinHumidity()) {
            mqttService.sendMoodToPlantMood(currentPlantmood.getArduinoSn(),Mood.DRY.toString());

        } else if (avarageOfPlantmoodData > currentPlantmood.getPlantSpecies().getMaxHumidity()) {
            mqttService.sendMoodToPlantMood(currentPlantmood.getArduinoSn(),Mood.WET.toString());

        } else {
            mqttService.sendMoodToPlantMood(currentPlantmood.getArduinoSn(),Mood.ALIVE.toString());
        }
    }

    public Plantmood getPlantmoodById(Integer id) {
        var optionalPlantmood = plantmoodRepository.findById(id);
        if (optionalPlantmood.isEmpty()) {
            logger.error("Couldn't find {}, with id {}", Plantmood.class.getName(), id);
            throw new EntityNotFoundException("Couldn't find " + Plantmood.class.getName() + " with id " + id);
        }
        var plantmood = optionalPlantmood.get();
        var optionalPlantmoodhistory = plantmoodHistoryRepository.findLatestPlantmoodHistoryByArduinoSn(plantmood.getArduinoSn());
        if (optionalPlantmoodhistory.isEmpty()) {
            logger.error("Couldn't find {}, with id {}", PlantmoodHistory.class.getName(), id);
            return this.modelMapper.map(plantmood, Plantmood.class);
        }
        plantmood.setHealth(optionalPlantmoodhistory.get().getHealth());
        return this.modelMapper.map(plantmood, Plantmood.class);
    }

    public List<Plantmood> getAllPlantmoods() {
        var plantmoods = plantmoodRepository.findAll();
        for (var plantmood: plantmoods) {
            var optionalPlantmoodhistory = plantmoodHistoryRepository.findLatestPlantmoodHistoryByArduinoSn(plantmood.getArduinoSn());
            if (optionalPlantmoodhistory.isEmpty()) {
                logger.error("Couldn't find instance of {}", PlantmoodHistory.class.getName());
                continue;
            }
            plantmood.setHealth(optionalPlantmoodhistory.get().getHealth());
        }
        return plantmoods.stream()
                .map(plantmood -> this.modelMapper.map(plantmood, Plantmood.class))
                .collect(Collectors.toList());
    }

    public Plantmood deletePlantmood(Integer id) {
        var plantmood = plantmoodRepository.findById(id);
        if (plantmood.isEmpty()) {
            logger.error("Couldn't find {}, with id {}", Plantmood.class.getName(), id);
            throw new EntityNotFoundException("Couldn't find " + Plantmood.class.getName() + " with id " + id);
        }
        plantmoodRepository.deleteById(id);
        return this.modelMapper.map(plantmood, Plantmood.class);
    }
}
