package com.oopa.domain;

import com.oopa.domain.services.PlantSpeciesService;
import com.oopa.domain.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class PlantSpeciesServiceTestConfig {

    @Bean
    public PlantSpeciesService plantSpeciesServiceMock() { return new PlantSpeciesService();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

