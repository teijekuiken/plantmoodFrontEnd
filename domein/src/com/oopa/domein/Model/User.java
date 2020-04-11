package com.oopa.domein.Model;

import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Date getCreatedAt() {
        return null;
    }
}
