package com.oopa.domein.services;

import com.oopa.interfaces.model.IPlantSpecies;

import java.util.List;

public class PlantSpeciesService {

    private PlantMoodRepository plantMoodRepository;

    public void addPlantSpecies(IPlantSpecies plantSpecies){
        plantMoodRepository.createPlantSpecie(plantSpecies);
    }

    public List<IPlantSpecies> getAllPlantSpecies(){
        List<IPlantSpecies> allPlantSpecies = plantMoodRepository.getAllPlantSpecies();
        return allPlantSpecies;
    }

    public IPlantSpecies getPlantSpeciesById(int id){
        IPlantSpecies plantSpecies = plantMoodRepository.getPlantSpecie();
        return plantSpecies;
    }

    public void deletePlantSpecies(int id){
        plantMoodRepository.deletePlantSpecie(id);
    }
}
