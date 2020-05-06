package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IPlantmoodhistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PlantmoodHistory implements IPlantmoodhistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int health;
    private int arduinoSn;
    private Date date;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public Date getCreatedAt() {
        return date;
    }
}
