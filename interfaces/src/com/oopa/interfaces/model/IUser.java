package com.oopa.interfaces.model;

import java.util.Date;

public interface IUser {
    int getId();

    void setId(int id);

    String getPassword();

    void setPassword(String password);

    String getName();

    void setName(String name);

    Date getCreatedAt();
}
