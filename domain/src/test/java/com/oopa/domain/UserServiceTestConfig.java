package com.oopa.domain;

import com.oopa.domain.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UserServiceTestConfig {

    @Bean
    public UserService userServiceMock() {return new UserService(); }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
