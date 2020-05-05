package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;

import java.util.Date;

public class PlantmoodHistory implements IPlantmoodhistory {

    private int id;
    private int health;
    private Date createdAt;
    private String arduinoSn;

    public PlantmoodHistory(int health, String arduinoSn) {
        this.health = health;
        this.arduinoSn = arduinoSn;
    }

    @Override
    public void addHistory(int health, int arduinoSn) {
        // TODO: 05/05/2020 add method to repository
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
    public Date getCreatedAt() {
        return createdAt;
    }

}
