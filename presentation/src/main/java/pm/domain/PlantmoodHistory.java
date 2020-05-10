package pm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IPlantmoodhistory;

import java.util.Date;

public class PlantmoodHistory implements IPlantmoodhistory {

    private int id;
    private int health;
    private Date createdAt;
    private String arduinoSn;

    public PlantmoodHistory(@JsonProperty("id") int id,
                            @JsonProperty("health") int health,
                            @JsonProperty("createdAt") Date createdAt,
                            @JsonProperty("arduinoSn") String arduinoSn) {
        this.id = id;
        this.health = health;
        this.createdAt = createdAt;
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
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
