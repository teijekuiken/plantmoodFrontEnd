package com.oopa.domein.model;

import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {

    private Integer id;
    private String name;
    private String email;
    private Date createAt;
    private String password;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
    }

    @Override
    public Date getCreatedAt() {
        return null;
    }

}
