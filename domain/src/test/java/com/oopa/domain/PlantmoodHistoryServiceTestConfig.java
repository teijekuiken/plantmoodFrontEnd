package com.oopa.domain;

import com.oopa.domain.services.PlantmoodHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class PlantmoodHistoryServiceTestConfig {

    @Bean
    public PlantmoodHistoryService plantmoodHistoryServiceMock() { return new PlantmoodHistoryService(); }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
