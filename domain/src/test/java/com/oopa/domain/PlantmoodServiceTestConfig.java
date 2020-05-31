package com.oopa.domain;

import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Plantmood;
import com.oopa.domain.services.MqttService;
import com.oopa.domain.services.PlantmoodHistoryService;
import com.oopa.domain.services.PlantmoodService;
import com.oopa.interfaces.model.IPlantmood;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class PlantmoodServiceTestConfig {

    @Bean
    public PlantmoodService plantmoodServiceMock() {return new PlantmoodService(); }

    @Bean
    public MqttConfiguration mqttConfigurationMock() {return new MqttConfiguration(); }

    @Bean
    public MqttService mqttServiceMock() {return new MqttService();}

    @Bean
    public Plantmood plantmoodMock() {return new Plantmood(); }

    @Bean
    public PlantmoodHistoryService plantmoodHistoryService() {return new PlantmoodHistoryService(); }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
