package com.oopa.domain;

import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.model.Plantmood;
import com.oopa.domain.services.MqttService;
import com.oopa.domain.services.PlantmoodHistoryService;
import com.oopa.domain.services.PlantmoodService;
import com.oopa.domain.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UserServiceTestConfig {

    @Bean
    public UserService userServiceMock() {return new UserService(); }

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
