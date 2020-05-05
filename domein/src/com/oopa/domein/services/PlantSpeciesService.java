package com.oopa.domein.services;

import com.oopa.interfaces.model.IPlantSpecies;

import java.util.List;

public class PlantSpeciesService {

    private PlantmoodRepository plantmoodRepository;

    public void addPlantSpecies(IPlantSpecies plantSpecies){
        plantmoodRepository.createPlantSpecie(plantSpecies);
    }

    public List<IPlantSpecies> getAllPlantSpecies(){
        List<IPlantSpecies> allPlantSpecies = plantmoodRepository.getAllPlantSpecies();
        return allPlantSpecies;
    }

    public IPlantSpecies getPlantSpeciesById(int id){
        IPlantSpecies plantSpecies = plantmoodRepository.getPlantSpecie();
        return plantSpecies;
    }

    public void deletePlantSpecies(int id){
        plantmoodRepository.deletePlantSpecie(id);
    }
}
