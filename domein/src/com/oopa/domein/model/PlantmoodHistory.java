package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;

import java.util.Date;

public class PlantmoodHistory implements IPlantmoodhistory {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public IPlantmood getPlantMood() {
        return null;
    }

    @Override
    public void setPlantMood(IPlantmood plantMood) {

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
