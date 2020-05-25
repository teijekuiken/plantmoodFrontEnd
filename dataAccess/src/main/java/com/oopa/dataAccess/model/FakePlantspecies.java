package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IPlantSpecies;

public class FakePlantspecies implements IPlantSpecies {
    private Integer id;
    private String name;
    private int minHumidity;
    private int maxHumidity;

    public FakePlantspecies(Integer id, String name, int minHumidity, int maxHumidity) {
        this.id = id;
        this.name = name;
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinHumidity() {
        return minHumidity;
    }

    public void setMinHumidity(int minHumidity) {
        this.minHumidity = minHumidity;
    }

    public int getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(int maxHumidity) {
        this.maxHumidity = maxHumidity;
    }
}
