package pm.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;

import java.util.Date;

public class PlantmoodHistory implements IPlantmoodhistory {

    private Integer Id;
    private IPlantmood plantmood;
    private int health;
    private Date createdAt;

    public PlantmoodHistory(@JsonProperty("id") Integer id,
                            @JsonProperty("plantmood") IPlantmood plantmood,
                            @JsonProperty("health") int health,
                            @JsonProperty("createdAt") Date createdAt) {
        Id = id;
        this.plantmood = plantmood;
        this.health = health;
        this.createdAt = createdAt;
    }

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public void setId(Integer id) {
        this.Id = id;
    }

    //@Override
    public IPlantmood getPlantMood() {
        return plantmood;
    }

    //@Override
    public void setPlantMood(IPlantmood plantMood) {
        this.plantmood = plantMood;
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
    public Date getCreatedAt() {
        return createdAt;
    }
}
