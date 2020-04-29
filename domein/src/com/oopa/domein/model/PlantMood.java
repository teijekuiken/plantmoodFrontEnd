package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

public class PlantMood implements IPlantMood {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public IUser getUser() {
        return null;
    }

    @Override
    public void setUser(IUser user) {

    }

    @Override
    public IPlantSpecies getPlantSpecies() {
        return null;
    }

    @Override
    public void setPlantSpecies(IPlantSpecies plantSpecie) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public String getArduinoId() {
        return null;
    }

    @Override
    public void setArduinoId(String arduinoId) {

    }
}
