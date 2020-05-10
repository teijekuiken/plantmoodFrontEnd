package pm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {

    private Integer id;
    private String password;
    private String name;
    private Date createdAt;
    private String email;

    public User(@JsonProperty("id") Integer id,
                @JsonProperty("password") String password,
                @JsonProperty("name") String name,
                @JsonProperty("createdAt") Date createdAt,
                @JsonProperty("email") String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
        this.email = email;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
