package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import com.oopa.interfaces.model.IPlantSpecies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantmoodService {
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

    public void getPlantStatus(IPlantmoodhistory plantmoodHistory, int plantspeciesId) {

    }

    public Plantmood getPlantmoodById(Integer id) {
        var plantmood = plantmoodRepository.findById(id);
        if (plantmood.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + Plantmood.class.getName() + " with id " + id);
        }

        return this.modelMapper.map(plantmood.get(), Plantmood.class);
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
        return this.modelMapper.map(plantmood.get(), Plantmood.class);
    }

}
