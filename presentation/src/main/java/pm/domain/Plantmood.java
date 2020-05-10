package pm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IUser;

public class Plantmood implements IPlantmood {
    private Integer id;
    private IUser user;
    private IPlantSpecies plantSpecies;
    private int health;
    private String arduinoSn;

    public Plantmood(@JsonProperty("id") Integer id,
                     @JsonProperty("user") IUser user,
                     @JsonProperty("plantspecies") IPlantSpecies plantSpecies,
                     @JsonProperty("health") int health,
                     @JsonProperty("arduinoid") String arduinoSn) {
        this.id = id;
        this.user = user;
        this.plantSpecies = plantSpecies;
        this.health = health;
        this.arduinoSn = arduinoSn;
    }

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
