package com.oopa.interfaces.model;

public interface IPlantSpecies {
    Integer getId();

    void setId(Integer id);

    String getName();
    void setName(String name);

    int getMinHumidity();
    void setMinHumidity(int minHumidity);

    int getMaxHumidity();
    void setMaxHumidity(int maxHumidity);
}
