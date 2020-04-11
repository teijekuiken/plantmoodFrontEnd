package com.oopa.interfaces.model;

public interface IPlantSpecies {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    int getMinHumidity();

    void setMinHumidity(int minHumidity);

    int getMaxHumidity();

    void setMaxHumidity(int maxHumidity);
}
