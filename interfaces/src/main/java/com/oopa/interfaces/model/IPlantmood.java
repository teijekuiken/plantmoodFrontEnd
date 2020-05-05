package com.oopa.interfaces.model;

public interface IPlantmood {
    int getId();

    void setId(int id);

    IUser getUser();

    void setUser(IUser user);

    IPlantSpecies getPlantSpecies();

    void setPlantSpecies(IPlantSpecies plantSpecies);

    int getHealth();

    void setHealth(int health);

    String getArduinoSn();

    void setArduinoSn(String arduinoId);
}
