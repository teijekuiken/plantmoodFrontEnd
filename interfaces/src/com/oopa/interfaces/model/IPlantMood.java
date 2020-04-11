package com.oopa.interfaces.model;

public interface IPlantMood {
    int getId();

    void setId(int id);

    IUser getUser();

    void setUser(IUser user);

    IPlantSpecies getPlantSpecies();

    void setPlantSpecies(IPlantSpecies plantSpecie);

    int getHealth();

    void setHealth(int health);

    String getArduinoId();

    void setArduinoId(String arduinoId);
}
