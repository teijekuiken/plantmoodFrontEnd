package com.oopa.domain.dto.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserOutputDTO {
    private Integer id;

    private String name;

    private String email;

    private Date createdAt;
}
