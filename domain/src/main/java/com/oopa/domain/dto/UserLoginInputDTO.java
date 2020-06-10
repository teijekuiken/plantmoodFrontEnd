package com.oopa.domain.dto;

import lombok.Data;

@Data
public class UserLoginInputDTO {
    private String email;

    private String password;

    public UserLoginInputDTO() {
    }

}
