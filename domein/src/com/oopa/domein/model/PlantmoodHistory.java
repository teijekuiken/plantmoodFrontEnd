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

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public IPlantmood getPlantmood() {
        return null;
    }

    @Override
    public void setPlantmood(IPlantmood plantMood) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public Date getCreatedAt() {
        return null;
    }

}
