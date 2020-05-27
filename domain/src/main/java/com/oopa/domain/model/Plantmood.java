package com.oopa.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

public class Plantmood implements IPlantmood {
    private int id;

    @JsonDeserialize(as = com.oopa.dataAccess.model.User.class)
    @JsonSerialize(as = com.oopa.dataAccess.model.User.class)
    private IUser user;

    @JsonDeserialize(as = com.oopa.dataAccess.model.PlantSpecies.class)
    @JsonSerialize(as = com.oopa.dataAccess.model.PlantSpecies.class)
    private IPlantSpecies plantSpecies;

    private int health;

    private String arduinoSn;

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
    public String getArduinoSn() {
        return arduinoSn;
    }

    @Override
    public void setArduinoSn(String arduinoSn) {
        this.arduinoSn = arduinoSn;
    }
}
