package com.oopa.domain.dto.user;

import lombok.Data;

@Data
public class CurrentUserInputDTO {
    private String jwt;

    public CurrentUserInputDTO() {
    }

}
