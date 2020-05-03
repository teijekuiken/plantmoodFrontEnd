package pm.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IPlantSpecies;
import pm.main.controllers.PlantspeciesController;

public class PlantSpecies implements IPlantSpecies {

    private Integer Id;
    private String name;
    private int MinHumidity;
    private int MaxHumidity;

    public PlantSpecies(@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name,
                        @JsonProperty("minhumidity") int minhumidity,
                        @JsonProperty("maxhumidity") int maxhumidity){
        this.Id = id;
        this.name = name;
        this.MinHumidity = minhumidity;
        this.MaxHumidity = maxhumidity;
    }
    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public void setId(Integer id) {
        this.Id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMinHumidity() {
        return this.MinHumidity;
    }

    @Override
    public void setMinHumidity(int minHumidity) {
        this.MinHumidity = minHumidity;
    }

    @Override
    public int getMaxHumidity() {
        return this.MaxHumidity;
    }

    @Override
    public void setMaxHumidity(int maxHumidity) {
        this.MaxHumidity = maxHumidity;
    }
}
