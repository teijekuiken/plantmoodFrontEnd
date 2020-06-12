package com.oopa.domain.dto;

import lombok.Data;

@Data
public class CurrentUserInputDTO {
    private String jwt;

    public CurrentUserInputDTO() {
    }

}
