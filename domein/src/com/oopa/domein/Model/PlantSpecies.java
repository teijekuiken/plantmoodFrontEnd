package com.oopa.domein.Model;

import com.oopa.interfaces.model.IPlantSpecies;

public class PlantSpecies implements IPlantSpecies {

    private int id;
    private String name;
    private int min_humidity;
    private int max_humidity;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getMinHumidity() {
        return 0;
    }

    @Override
    public void setMinHumidity(int minHumidity) {

    }

    @Override
    public int getMaxHumidity() {
        return 0;
    }

    @Override
    public void setMaxHumidity(int maxHumidity) {

    }
}
