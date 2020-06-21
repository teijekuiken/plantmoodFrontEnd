package com.oopa.domain.dto.user;

import com.oopa.domain.dto.plantmood.PlantmoodOutputDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserOutputDTO {
    private Integer id;

    private String name;

    private String email;

    private Date createdAt;

    private List<PlantmoodOutputDTO> plantmoods;
}
