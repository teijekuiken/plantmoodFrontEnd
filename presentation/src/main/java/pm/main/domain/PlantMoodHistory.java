package pm.main.domain;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantMoodHistory;

import java.util.Date;

public class PlantMoodHistory implements IPlantMoodHistory {

    private int Id;
    private IPlantMood plantmood;
    private int health;
    private Date createdAt;

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public void setId(int id) {
        this.Id = id;
    }

    @Override
    public IPlantMood getPlantMood() {
        return plantmood;
    }

    @Override
    public void setPlantMood(IPlantMood plantMood) {
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
