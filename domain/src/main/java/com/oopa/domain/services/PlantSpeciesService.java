package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantSpeciesRepository;
import com.oopa.interfaces.model.IPlantSpecies;
import java.util.List;
import java.util.Optional;

public class PlantSpeciesService {

   private PlantSpeciesRepository plantSpeciesRepository;

    public void addPlantSpecies(IPlantSpecies plantSpecies){
        plantSpeciesRepository.save(plantSpecies);
    }

    public List<IPlantSpecies> getAllPlantSpecies(){
        return (List<IPlantSpecies>) plantSpeciesRepository.findAll();
    }

    public Optional<IPlantSpecies> getPlantSpeciesById(Integer id){
        return plantSpeciesRepository.findById(id);
    }

    public String deletePlantSpecies(Integer id){
        Optional<IPlantSpecies> optionalPlantSpecie = plantSpeciesRepository.findById(id);
        if (optionalPlantSpecie.isPresent()) {
            plantSpeciesRepository.delete(optionalPlantSpecie.get());
            return "PlantSpecie with id:" + id + "is deleted";
        } else {
            throw new RuntimeException("PlantSpecie with id: " + id + "not found");
        }
    }
}
