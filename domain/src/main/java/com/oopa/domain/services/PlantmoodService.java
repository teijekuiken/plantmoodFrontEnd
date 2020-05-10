package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import com.oopa.interfaces.model.IPlantSpecies;

public class PlantmoodService {
    private Plantmood plantmood;
    private PlantmoodRepository plantmoodRepository;

    public void addPlantmood(IPlantmood plantMood) {

    }

    public void linkPlantSpieciesToPlantmood(IPlantSpecies plantSpecies, IPlantmood plantMood) {
    }

    public void deletePlantmoodFromUser(int userId, int plantmoodId) {

    }

    public void switchPlantmoodFromUser(int userId, int plantmoodId) {

    }

    public void getPlantStatus(IPlantmoodhistory plantmoodHistory, int plantspeciesId) {

    }

    public void getPlantmoodById(int plantmoodId) {

    }

    public void getAllPlantmoods() {
    }

    public void deletePlantmood(int platmoodId) {

    }

    public void updatePlantmood(IPlantmood plantmood) {

    }
}
