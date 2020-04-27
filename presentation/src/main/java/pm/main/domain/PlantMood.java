package pm.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

public class PlantMood implements IPlantMood{

    private int Id;
    private IUser user;
    private IPlantSpecies plantSpecies;
    private int health;
    private String arduinoId;

    public PlantMood(@JsonProperty("id") int id,
                     @JsonProperty("user") IUser user,
                     @JsonProperty("plantspecies") IPlantSpecies plantSpecies,
                     @JsonProperty("health") int health,
                     @JsonProperty("arduinoid") String arduinoId) {
        Id = id;
        this.user = user;
        this.plantSpecies = plantSpecies;
        this.health = health;
        this.arduinoId = arduinoId;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public void setId(int id) {
        this.Id = id;
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
        return plantSpecies;
    }

    @Override
    public void setPlantSpecies(IPlantSpecies plantSpecies) {
        this.plantSpecies =  plantSpecies;
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
    public String getArduinoId() {
        return this.arduinoId;
    }

    @Override
    public void setArduinoId(String arduinoId) {
        this.arduinoId = arduinoId;
    }
}
