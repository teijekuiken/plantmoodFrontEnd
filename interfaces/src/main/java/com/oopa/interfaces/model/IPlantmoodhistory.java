package com.oopa.interfaces.model;

import java.util.Date;

public interface IPlantmoodhistory {

    Integer getId();
    void setId(Integer id);
    int getHealth();
    void setHealth(int health);
    Date getCreatedAt();
    void setCreatedAt(Date createdAt);
    String getArduinoSn();
    void setArduinoSn(String arduinoSn);
}
