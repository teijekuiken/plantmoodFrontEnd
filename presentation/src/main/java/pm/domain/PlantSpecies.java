package pm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IPlantSpecies;

public class PlantSpecies implements IPlantSpecies {

    private Integer id;
    private String name;
    private int minHumidity;
    private int maxHumidity;

    public PlantSpecies(@JsonProperty("id") Integer id,
                        @JsonProperty("name") String name,
                        @JsonProperty("minhumidity") int minhumidity,
                        @JsonProperty("maxhumidity") int maxhumidity){
        this.id = id;
        this.name = name;
        this.minHumidity = minhumidity;
        this.maxHumidity = maxhumidity;
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
