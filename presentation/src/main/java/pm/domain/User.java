package pm.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {

    private Integer Id;
    private String password;
    private String name;
    private Date createdAt;

    public User(@JsonProperty("id") Integer id,
                @JsonProperty("password") String password,
                @JsonProperty("name") String name,
                @JsonProperty("createdAt") Date createdAt) {
        Id = id;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public void setId(Integer id) {
        this.Id = id;
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
        return this.name;
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

    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }
}
