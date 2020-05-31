package com.oopa.domain.services;

import com.oopa.dataAccess.model.PlantmoodHistory;
import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.domain.PlantmoodHistoryServiceTestConfig;

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
    public void CheckPlantmoodHistoryServiceForExceptionsTest() {
        //Arrange
        int unknownId = 0;

        //Assert
        assertThrows(EntityNotFoundException.class, () -> {plantmoodHistoryServiceMock.getPlantmoodHistoryById(unknownId);
        });
    }

    @Test
    void getAllPlantmoodHistortiesTest() {
        //Act
        int expected = histories.size();
        int actual = plantmoodHistoryServiceMock.getAllPlantmoodHistorties().size();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getPlantmoodHistoryByIdTest() {
        //Act
        Integer expected = histories.get(0).getId();
        Integer actual = plantmoodHistoryServiceMock.getPlantmoodHistoryById(1).getId();

        //Assert
        assertEquals(expected, actual);
    }
}