package com.oopa.domain.services;

import com.oopa.dataAccess.model.FakePlantspecies;
import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.PlantSpecies;
import com.oopa.domain.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import com.oopa.interfaces.model.IPlantSpecies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantmoodService {

    private LocalDateTime lastTestTime;

    public PlantmoodService() {
        lastTestTime = LocalDateTime.now();
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlantmoodRepository plantmoodRepository;

    public Plantmood addPlantmood(Plantmood plantmood) {
        var plantmoodEntity = this.modelMapper.map(plantmood, com.oopa.dataAccess.model.Plantmood.class);

        return this.modelMapper.map(plantmoodRepository.save(plantmoodEntity), Plantmood.class);
    }

    public void linkPlantSpieciesToPlantmood(IPlantSpecies plantSpecies, IPlantmood plantMood) {
    }

    public void deletePlantmoodFromUser(int userId, int plantmoodId) {

    }

    public void switchPlantmoodFromUser(int userId, int plantmoodId) {

    }

    public void getPlantStatus(List<IPlantmoodhistory> plantmoodhistories, FakePlantspecies plantspecies) {
        if (plantmoodhistories.size() > 4 && tenMinutesArePassed(lastTestTime)) {
            double valueOfPlantmoodData = 0;
            double avarageOfPlantmoodData = 0;
            double multiplier = 1;
            double substractionOfAverage = 0;

            lastTestTime = LocalDateTime.now();

            plantmoodhistories.sort(Comparator.comparing(IPlantmoodhistory::getCreatedAt));
            List<IPlantmoodhistory> subListPlantmoodhistories = plantmoodhistories.stream()
                    .sorted(Comparator.comparing(IPlantmoodhistory::getCreatedAt).reversed())
                    .collect(Collectors.toList()).subList(0, 5);

            for (IPlantmoodhistory history: subListPlantmoodhistories) {
                valueOfPlantmoodData += multiplier * history.getHealth();
                substractionOfAverage += multiplier;
                multiplier -= 0.2;
            }
            avarageOfPlantmoodData = valueOfPlantmoodData / substractionOfAverage;

            if (avarageOfPlantmoodData < plantspecies.getMinHumidity()) {
                System.out.println("Geef water");
            } else if (avarageOfPlantmoodData > plantspecies.getMaxHumidity()) {
                System.out.println("Te veel water");
            }
            System.out.println("De plant is op het juiste niveau");
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

    private boolean tenMinutesArePassed(LocalDateTime lastCheck) {
        return lastCheck.isBefore(LocalDateTime.now().minusMinutes(10));
    }


}
