package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

public class Plantmood implements IPlantmood {
    private int id;
//    private String name; Staat wel in het klassendiagram
    private User user;
    private PlantSpecies plantSpecies;
    private int Health;
    private String ArduinoId;

    @Override
    public Integer getId() {
        return 0;
    }

    @Override
    public void setId(Integer id) {

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
    public void setPlantSpecies(IPlantSpecies plantSpecies) {

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
        return ArduinoId;
    }

    @Override
    public void setArduinoId(String arduinoId) {

    }
}
