package com.oopa.interfaces.model;

import java.util.Date;

public interface IPlantMoodHistory {
    int getId();

    void setId(int id);

    IPlantMood getPlantMood();

    void setPlantMood(IPlantMood plantMood);

    int getHealth();

    void setHealth(int health);

    Date getCreatedAt();
}
