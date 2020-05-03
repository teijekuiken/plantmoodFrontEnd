package com.oopa.interfaces.model;

public interface IPlantMood {
    Integer getId();

    void setId(Integer id);

    IUser getUser();

    void setUser(IUser user);

    IPlantSpecies getPlantSpecies();

    void setPlantSpecies(IPlantSpecies plantSpecies);

    int getHealth();

    void setHealth(int health);

    String getArduinoId();

    void setArduinoId(String arduinoId);
}
