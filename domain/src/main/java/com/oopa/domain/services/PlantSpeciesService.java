package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantSpeciesRepository;
import com.oopa.domain.model.PlantSpecies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantSpeciesService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlantSpeciesRepository plantSpeciesRepository;

    public PlantSpecies addPlantSpecies(PlantSpecies plantSpecies){
        var plantSpeciesEntity = this.modelMapper.map(plantSpecies, com.oopa.dataAccess.model.PlantSpecies.class);

        return this.modelMapper.map(plantSpeciesRepository.save(plantSpeciesEntity), PlantSpecies.class);
    }

    public List<PlantSpecies> getAllPlantSpecies(){
        return plantSpeciesRepository.findAll().stream()
                .map(plantSpecies -> this.modelMapper.map(plantSpecies, PlantSpecies.class))
                .collect(Collectors.toList());
    }

    public PlantSpecies getPlantSpeciesById(Integer id){
        var plantSpecies = plantSpeciesRepository.findById(id);

        if (plantSpecies.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + PlantSpecies.class.getName() + " with id " + id);
        }

        return this.modelMapper.map(plantSpecies.get(), PlantSpecies.class);
    }

    public PlantSpecies deletePlantSpecies(Integer id){
        var plantSpecies = plantSpeciesRepository.findById(id);
        if (plantSpecies.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + PlantSpecies.class.getName() + " with id " + id);
        }

        plantSpeciesRepository.deleteById(id);
        return this.modelMapper.map(plantSpecies.get(), PlantSpecies.class);
    }
}
