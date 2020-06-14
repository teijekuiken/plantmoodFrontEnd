package com.oopa.domain.dto.user;

public class UserLoginOutputDTO {
    private final String jwt;

    public UserLoginOutputDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }
}
