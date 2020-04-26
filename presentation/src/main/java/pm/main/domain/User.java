package pm.main.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {

    private int Id;
    private String password;
    private String name;
    private Date createdAt;

    public User(@JsonProperty("id") int id,
                @JsonProperty("password") String password,
                @JsonProperty("name") String name,
                @JsonProperty("createdAt") Date createdAt) {
        Id = id;
        this.password = password;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public void setId(int id) {
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
    public Date getCreatedAt() {
        return createdAt;
    }
}
