package com.oopa.domain.model;

import com.oopa.interfaces.model.IPlantmoodhistory;
import java.util.Date;

public class PlantmoodHistory implements IPlantmoodhistory {

    private Integer id;
    private int health;
    private Date createdAt;
    private String arduinoSn;

    public PlantmoodHistory(String arduinoSn,int health) {
        this.health = health;
        this.arduinoSn = arduinoSn;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
