package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IPlantSpecies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlantSpecies implements IPlantSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int minHumidity;

    private int maxHumidity;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMinHumidity() {
        return minHumidity;
    }

    @Override
    public void setMinHumidity(int minHumidity) {
        this.minHumidity = minHumidity;
    }

    @Override
    public int getMaxHumidity() {
        return maxHumidity;
    }

    @Override
    public void setMaxHumidity(int maxHumidity) {
        this.maxHumidity = maxHumidity;
    }
}
