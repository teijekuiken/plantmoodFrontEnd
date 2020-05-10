package com.oopa.domain.model;

import com.oopa.interfaces.model.IUser;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void Add_user_to_list() {
        //Arrange
        List<IUser> UsersList = new ArrayList<>();
        IUser expectedUser = new User();
        UsersList.add(expectedUser);

        //Act
        IUser actualUser = UsersList.get(0);

        //Assert
        assertEquals(expectedUser, actualUser);
    }
}