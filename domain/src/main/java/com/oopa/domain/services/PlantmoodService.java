package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Plantmood;
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
        double avarage = 0;

        if (plantmoodhistories.size() > 4 ) {
            double valueOfPlantmoodData = 0;

            double multiplier = 1;
            double substractionOfAverage = 0;

            List<IPlantmoodhistory> subListPlantmoodhistories = plantmoodhistories.stream()
                    .sorted(Comparator.comparing(IPlantmoodhistory::getCreatedAt).reversed())
                    .collect(Collectors.toList()).subList(0, 5);

            for (IPlantmoodhistory history: subListPlantmoodhistories) {
                valueOfPlantmoodData += multiplier * history.getHealth();
                substractionOfAverage += multiplier;
                multiplier -= 0.2;
            }
            avarage = valueOfPlantmoodData / substractionOfAverage;
        }
        return avarage;
    }

    public void decideMood(double avarageOfPlantmoodData, IPlantmood currentPlantmood){
        if (avarageOfPlantmoodData < currentPlantmood.getPlantSpecies().getMinHumidity()) {
            mood = "DRY";
            mqttService.sendMoodToPlantMood(currentPlantmood.getArduinoSn(), mood);

        } else if (avarageOfPlantmoodData > currentPlantmood.getPlantSpecies().getMaxHumidity()) {
            mood = "WET";
            mqttService.sendMoodToPlantMood(currentPlantmood.getArduinoSn(),mood);
        }else {
            mood = "ALIVE";
            mqttService.sendMoodToPlantMood(currentPlantmood.getArduinoSn(), mood);
        }
    }

    public Plantmood getPlantmoodById(Integer id) {
        var plantmood = plantmoodRepository.findById(id);
        if (plantmood.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + Plantmood.class.getName() + " with id " + id);
        }
        return this.modelMapper.map(plantmood, Plantmood.class);
    }

    public List<Plantmood> getAllPlantmoods() {
        return plantmoodRepository.findAll().stream()
                .map(plantmood -> this.modelMapper.map(plantmood, Plantmood.class))
                .collect(Collectors.toList());
    }

    public Plantmood deletePlantmood(Integer id) {
        var plantmood = plantmoodRepository.findById(id);
        if (plantmood.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + Plantmood.class.getName() + " with id " + id);
        }

        plantmoodRepository.deleteById(id);
        return this.modelMapper.map(plantmood, Plantmood.class);
    }
}
