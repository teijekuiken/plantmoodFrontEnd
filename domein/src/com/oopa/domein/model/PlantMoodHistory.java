package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantMoodHistory;

import java.util.Date;

public class PlantMoodHistory implements IPlantMoodHistory {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public IPlantMood getPlantMood() {
        return null;
    }

    @Override
    public void setPlantMood(IPlantMood plantMood) {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public Date getCreatedAt() {
        return null;
    }
}
