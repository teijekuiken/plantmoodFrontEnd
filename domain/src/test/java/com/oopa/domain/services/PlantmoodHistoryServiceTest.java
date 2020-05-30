package com.oopa.domain.services;

import com.oopa.dataAccess.model.PlantmoodHistory;
import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.dataAccess.repositories.UserRepository;
import com.oopa.domain.PlantSpeciesServiceTestConfig;
import com.oopa.domain.PlantmoodHistoryServiceTestConfig;
import com.oopa.domain.UserServiceTestConfig;
import com.oopa.domain.services.PlantmoodHistoryService;
import com.oopa.domain.services.UserService;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PlantmoodHistoryService.class)
@Import({PlantmoodHistoryServiceTestConfig.class})
class PlantmoodHistoryServiceTest {

    List<PlantmoodHistory> histories = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Date date = new Date(System.currentTimeMillis());
        PlantmoodHistory plantmoodHistory = new PlantmoodHistory();
        plantmoodHistory.setId(1);
        plantmoodHistory.setArduinoSn("testmood");
        plantmoodHistory.setHealth(90);
        plantmoodHistory.setCreatedAt(date);

        histories.add(this.modelMapper.map(plantmoodHistory, com.oopa.dataAccess.model.PlantmoodHistory.class));

        Mockito.when(plantmoodHistoryRepository.findById(plantmoodHistory.getId())).thenReturn(
                Optional.of(this.modelMapper.map(plantmoodHistory, com.oopa.dataAccess.model.PlantmoodHistory.class))
        );

//        Mockito.when(plantmoodHistoryRepository.findAllByArduinoSn(plantmoodHistory.getArduinoSn())).thenReturn(
//                Optional.of(this.modelMapper.map(List<PlantmoodHistory>, com.oopa.dataAccess.model.PlantmoodHistory.class))
//        );

        Mockito.when(plantmoodHistoryRepository.findAll()).thenReturn(
                histories
        );
    }

    @MockBean
    private PlantmoodHistoryRepository plantmoodHistoryRepository;

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryServiceMock;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void addHistory() {
    }

    @Test
    void getAllPlantmoodHistorties() {
        //Act
        int expected = histories.size();
        int actual = plantmoodHistoryServiceMock.getAllPlantmoodHistorties().size();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void deletePlantmoodHistory() {
    }

    @Test
    void getPlantmoodHistoryById() {
        //Act
        Integer expected = histories.get(0).getId();
        Integer actual = plantmoodHistoryServiceMock.getPlantmoodHistoryById(1).getId();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAllHistoryByArduinoSn() {
        //Arrange
//        PlantmoodHistory testmood = histories.stream()
//                .filter(plantmoodHistory -> "testmood".equals(plantmoodHistory.getArduinoSn()))
//                .findAny()
//                .orElse(null);
//
//
//        //Act
//        int expected = histories.size();
//        int actual = plantmoodHistoryServiceMock.getAllHistoryByArduinoSn("testmood").size();
//
//        //Assert
//        assertEquals(expected, actual);
    }
}