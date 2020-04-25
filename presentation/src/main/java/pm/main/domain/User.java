package pm.main.domain;

import com.oopa.interfaces.model.IUser;

import java.util.Date;

public class User implements IUser {

    private int Id;
    private String password;
    private String name;
    private Date createdAt;

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
