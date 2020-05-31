package com.oopa.domain.services;

import com.oopa.dataAccess.model.User;
import com.oopa.dataAccess.repositories.UserRepository;
import com.oopa.domain.UserServiceTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = UserService.class)
@Import({UserServiceTestConfig.class})
class UserServiceTest {

    List<User> users = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Date date = new Date(System.currentTimeMillis());
        User john = new User();
        john.setId(1);
        john.setCreatedAt(date);
        john.setEmail("johndoe@test.com");
        john.setName("John");
        john.setPassword("password");

        users.add(this.modelMapper.map(john, com.oopa.dataAccess.model.User.class));

        Mockito.when(userRepository.findById(john.getId())).thenReturn(
                Optional.of(this.modelMapper.map(john, com.oopa.dataAccess.model.User.class))
        );

        Mockito.when(userRepository.findAll()).thenReturn(
                users
        );
    }

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userServiceMock;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void CheckUserServiceForExceptionsTest() {
        //Arrange
        int unknownId = 0;

        //Assert
        assertThrows(EntityNotFoundException.class, () -> {userServiceMock.getUserById(unknownId);
        });
    }

    @Test
    void getUserById() {
        //Act
        String expected = users.get(0).getName();
        String actual = userServiceMock.getUserById(1).getName();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAllUsers() {
        //Act
        int expected = users.size();
        int actual = userServiceMock.getAllUsers().size();

        //Assert
        assertEquals(expected, actual);
    }
}