package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

import javax.persistence.*;

@Entity
public class Plantmood implements IPlantmood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    private IUser user;

    @ManyToOne(targetEntity = PlantSpecies.class)
    private IPlantSpecies plantSpecies;

    @Transient
    private int health;

    @Column(unique = true)
    private String arduinoSn;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public void setUser(IUser user) {
        this.user = user;
    }

    @Override
    public IPlantSpecies getPlantSpecies() {
        return plantSpecies;
    }

    @Override
    public void setPlantSpecies(IPlantSpecies plantSpecies) {
        this.plantSpecies = plantSpecies;
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
    public String getArduinoSn() {
        return arduinoSn;
    }

    @Override
    public void setArduinoSn(String arduinoSn) {
        this.arduinoSn = arduinoSn;
    }
}
