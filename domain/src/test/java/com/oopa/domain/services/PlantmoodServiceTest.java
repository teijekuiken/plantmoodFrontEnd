package com.oopa.domain.services;

import com.oopa.dataAccess.model.PlantSpecies;
import com.oopa.dataAccess.model.Plantmood;
import com.oopa.dataAccess.repositories.PlantSpeciesRepository;
import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.PlantmoodHistoryServiceTestConfig;
import com.oopa.domain.PlantmoodServiceTestConfig;
import com.oopa.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PlantmoodService.class)
@Import({PlantmoodServiceTestConfig.class})
class PlantmoodServiceTest {

    List<Plantmood> plantmoods = new ArrayList<>();

    @BeforeEach
    public void setup() {
        PlantSpecies orchid = new PlantSpecies();
        User john = new User();
        Plantmood testmood = new Plantmood();
        testmood.setId(1);
        testmood.setArduinoSn("testmood");
        testmood.setHealth(90);
        testmood.setPlantSpecies(orchid);
        testmood.setUser(john);

        plantmoods.add(this.modelMapper.map(testmood, com.oopa.dataAccess.model.Plantmood.class));

        Mockito.when(plantmoodRepository.findById(testmood.getId())).thenReturn(
                Optional.of(this.modelMapper.map(testmood, com.oopa.dataAccess.model.Plantmood.class))
        );

        Mockito.when(plantmoodRepository.findAll()).thenReturn(
                plantmoods
        );

//        Mockito.when(plantmoodRepository.findByArduinoSn())
    }

    @MockBean
    private PlantmoodRepository plantmoodRepository;

    @MockBean
    private PlantmoodHistoryRepository plantmoodHistoryRepository;

//    @Autowired
//    private MqttService mqttServiceMock;

    @Autowired
    private PlantmoodService plantmoodServiceMock;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void addPlantmood() {
    }

    @Test
    void getPlantStatus() {
    }

    @Test
    void calculateAverageHistory() {
    }

    @Test
    void decideMood() {
    }

    @Test
    void getPlantmoodById() {
        //Act
        int expected = plantmoods.get(0).getId();
        int actual = plantmoodServiceMock.getPlantmoodById(1).getId();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAllPlantmoods() {
        //Act
        int expected = plantmoods.size();
        int actual = plantmoodServiceMock.getAllPlantmoods().size();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void deletePlantmood() {
    }
}