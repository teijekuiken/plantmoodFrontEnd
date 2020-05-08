package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

public class Plantmood implements IPlantmood {
    private Integer id;
//    private String name; Staat wel in het klassendiagram
    private IUser user;
    private IPlantSpecies plantSpecies;
    private int health;
    private String arduinoId;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public void setUser(IUser user) {
        this.user = user;
    }

    @Override
    public IPlantSpecies getPlantSpecies() {
        return plantSpecies;
    }

    @Override
    public void setPlantSpecies(IPlantSpecies plantSpecies) {
        this.plantSpecies = plantSpecies;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getArduinoId() {
        return null;
    }

    @Override
    public void setArduinoId(String arduinoSn) {
        this.arduinoId = arduinoSn;
    }
}
