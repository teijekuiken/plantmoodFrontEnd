package com.oopa.interfaces.model;

import java.util.Date;

public interface IPlantmoodhistory {

    int getId();
    void setId(int id);
    int getHealth();
    void setHealth(int health);
    Date getCreatedAt();
    void addHistory(int health, int arduinoSn);
}
