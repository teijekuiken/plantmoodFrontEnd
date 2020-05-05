package com.oopa.domein.model;

import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {

    private int id;
    private String name;
    private String email;
    private Date createdAt;
    private String password;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void addUser(String name, String email, String password) {
    }

}
