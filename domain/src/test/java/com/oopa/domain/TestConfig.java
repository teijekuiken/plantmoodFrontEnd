package com.oopa.domain;

import com.oopa.domain.services.PlantSpeciesService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {
    @Bean
    public PlantSpeciesService plantSpeciesServiceMock() {
        return new PlantSpeciesService();
    }
}
