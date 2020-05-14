package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import com.oopa.interfaces.model.IPlantSpecies;
import java.util.List;
import java.util.Optional;

public class PlantmoodService {
    private Plantmood plantmood;
    private PlantmoodRepository plantmoodRepository;

    public void addPlantmood(IPlantmood plantMood) {
        plantmoodRepository.save(plantMood);
    }

    public void getPlantStatus(IPlantmoodhistory plantmoodHistory, int plantspeciesId) {

    }

    public Optional<IPlantmood> getPlantmoodById(int plantmoodId) {
        return plantmoodRepository.findById(plantmoodId);
    }

    public List<IPlantmood> getAllPlantmoods() {
        return (List<IPlantmood>) plantmoodRepository.findAll();
    }

    public String deletePlantmood(Integer plantmoodId) {
        Optional<IPlantmood> optionalPlantmood = plantmoodRepository.findById(plantmoodId);
        if (optionalPlantmood.isPresent()) {
            plantmoodRepository.delete(optionalPlantmood.get());
            return "PlantMood with id:" + plantmoodId + "is deleted";
        } else {
            throw new RuntimeException("PlantMood with id: " + plantmoodId + "not found");
        }
    }
    // TODO: 11/05/2020 Not used for now (Voorlopig denk ik makkelijker om deze gelijk mee te geven ipv later te linken)
    public void linkPlantSpieciesToPlantmood(IPlantSpecies plantSpecies, IPlantmood plantMood) {
    }
    // TODO: 11/05/2020 Not used for now
    public void deletePlantmoodFromUser(int userId, int plantmoodId) {

    }
    // TODO: 11/05/2020 Not used for now
    public void switchPlantmoodFromUser(int userId, int plantmoodId) {

    }
    // TODO: 11/05/2020 Not used for now
    public void updatePlantmood(IPlantmood plantmood) {

    }
}
