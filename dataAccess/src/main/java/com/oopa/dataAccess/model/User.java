package com.oopa.dataAccess.model;

import com.oopa.interfaces.model.IUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User implements IUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String password;

    private String name;

    private String email;

    private Date date;

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return this.password;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Date getCreatedAt() {
        return this.date;
    }
}
