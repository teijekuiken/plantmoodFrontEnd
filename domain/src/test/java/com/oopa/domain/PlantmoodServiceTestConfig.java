package com.oopa.domain;

import com.oopa.domain.services.MqttService;
import com.oopa.domain.services.PlantmoodHistoryService;
import com.oopa.domain.services.PlantmoodService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class PlantmoodServiceTestConfig {

    @Bean
    public PlantmoodService plantmoodServiceMock() { return new PlantmoodService();}

    @Bean
    public MqttService mqttServiceMock() { return new MqttService(); }

    @Bean
    public MqttConfiguration mqttConfiguration() { return new MqttConfiguration(); }

    @Bean
    public PlantmoodHistoryService plantmoodHistoryServiceMock() { return new PlantmoodHistoryService(); }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
