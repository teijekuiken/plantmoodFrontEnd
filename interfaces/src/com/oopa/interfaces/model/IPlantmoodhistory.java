package com.oopa.interfaces.model;

import java.util.Date;

public interface IPlantmoodhistory {
    int getId();

    void setId(int id);

    IPlantmood getPlantMood();

    void setPlantMood(IPlantmood plantMood);

    int getHealth();

    void setHealth(int health);

    Date getCreatedAt();
}
