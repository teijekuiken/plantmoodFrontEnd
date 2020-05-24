package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IPlantmoodhistory;

import java.time.LocalDateTime;
import java.util.Date;

public class FakePlantmoodHistory implements IPlantmoodhistory {

    private Integer id;
    private int health;
    private String arduinoSn;
    private LocalDateTime date;

    public FakePlantmoodHistory(Integer id, int health, String arduinoSn, LocalDateTime date) {
        this.id = id;
        this.health = health;
        this.arduinoSn = arduinoSn;
        this.date = date;
    }

    @Override
    public Date getCreatedAt() {
        return null;
    }

    @Override
    public void setCreatedAt(Date createdAt) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getArduinoSn() {
        return arduinoSn;
    }

    public void setArduinoSn(String arduinoSn) {
        this.arduinoSn = arduinoSn;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
