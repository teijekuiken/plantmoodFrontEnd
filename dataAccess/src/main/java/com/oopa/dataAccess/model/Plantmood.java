package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

import javax.persistence.*;

@Entity
public class Plantmood implements IPlantMood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    private IUser user;

    @ManyToOne(targetEntity = PlantSpecies.class)
    private IPlantSpecies plantSpecies;

    private int health;

    private String arduinoId;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public IUser getUser() {
        return this.user;
    }

    @Override
    public void setUser(IUser user) {
        this.user = user;
    }

    @Override
    public IPlantSpecies getPlantSpecies() {
        return this.plantSpecies;
    }

    @Override
    public void setPlantSpecies(IPlantSpecies plantSpecies) {
        this.plantSpecies = plantSpecies;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getArduinoId() {
        return null;
    }

    @Override
    public void setArduinoId(String arduinoId) {
        this.arduinoId = arduinoId;
    }
}
