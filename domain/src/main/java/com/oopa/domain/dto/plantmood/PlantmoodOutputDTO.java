package com.oopa.domain.dto.plantmood;

import lombok.Data;

@Data
public class PlantmoodOutputDTO {
    private Integer id;

    private int health;

    private String arduinoSn;

    private Integer userId;

    private String userName;

    private String plantSpeciesName;
}
