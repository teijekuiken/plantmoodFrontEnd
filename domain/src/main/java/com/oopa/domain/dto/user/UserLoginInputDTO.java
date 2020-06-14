package com.oopa.domain.dto.user;

import lombok.Data;

@Data
public class UserLoginInputDTO {
    private String email;

    private String password;

    public UserLoginInputDTO() {
    }

}
