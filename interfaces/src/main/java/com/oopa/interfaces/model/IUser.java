package com.oopa.interfaces.model;

import java.util.Date;

public interface IUser {

    Integer getId();
    void setId(Integer id);
    String getPassword();
    void setPassword(String password);
    String getName();
    void setName(String name);
    String getEmail();
    void setEmail(String email);
    Date getCreatedAt();
}
