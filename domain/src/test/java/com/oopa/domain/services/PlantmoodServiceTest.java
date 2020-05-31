package com.oopa.domain.services;

import com.oopa.dataAccess.model.PlantSpecies;
import com.oopa.dataAccess.model.Plantmood;
import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.dataAccess.repositories.PlantmoodRepository;
import com.oopa.domain.PlantmoodServiceTestConfig;
import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.domain.model.User;
import com.oopa.interfaces.model.IPlantmoodhistory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = PlantmoodService.class)
@Import({PlantmoodServiceTestConfig.class})
class PlantmoodServiceTest {

    List<Plantmood> plantmoods = new ArrayList<>();
    List<IPlantmoodhistory> plantmoodhistories = new ArrayList<>();

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

        Date date = new Date(System.currentTimeMillis());

        PlantmoodHistory plantmoodHistory1 = new PlantmoodHistory();
        plantmoodHistory1.setCreatedAt(date);
        plantmoodHistory1.setHealth(60);

        PlantmoodHistory plantmoodHistory2 = new PlantmoodHistory();
        plantmoodHistory2.setCreatedAt(date);
        plantmoodHistory2.setHealth(70);

        PlantmoodHistory plantmoodHistory3 = new PlantmoodHistory();
        plantmoodHistory3.setCreatedAt(date);
        plantmoodHistory3.setHealth(80);

        PlantmoodHistory plantmoodHistory4 = new PlantmoodHistory();
        plantmoodHistory4.setCreatedAt(date);
        plantmoodHistory4.setHealth(90);

        PlantmoodHistory plantmoodHistory5 = new PlantmoodHistory();
        plantmoodHistory5.setCreatedAt(date);
        plantmoodHistory5.setHealth(100);

        plantmoodhistories.add(plantmoodHistory1);
        plantmoodhistories.add(plantmoodHistory2);
        plantmoodhistories.add(plantmoodHistory3);
        plantmoodhistories.add(plantmoodHistory4);
        plantmoodhistories.add(plantmoodHistory5);
    }

    @MockBean
    private PlantmoodRepository plantmoodRepository;

    @MockBean
    private PlantmoodHistoryRepository plantmoodHistoryRepository;

    @Autowired
    private PlantmoodService plantmoodServiceMock;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void CheckPlantmoodServiceForExceptionsTest() {
        //Arrange
        int unknownId = 0;

        //Assert
        assertThrows(EntityNotFoundException.class, () -> {plantmoodServiceMock.getPlantmoodById(unknownId);
        });
    }

    @Test
    void getSublistOfHistoryTest() {
        //Act
        IPlantmoodhistory expected = plantmoodhistories.stream()
                .sorted(Comparator.comparing(IPlantmoodhistory::getCreatedAt).reversed())
                .collect(Collectors.toList()).subList(0, 5).get(2);
        IPlantmoodhistory actual = plantmoodServiceMock.getSublistOfHistory(plantmoodhistories).get(2);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateAverageHistoryTest() {
        //Arrange
        double totalHealth = 0;
        double average = 0;
        double substractionOfAverage = 0;
        double multiplier = 1;

        for (int i = 0; i < plantmoodServiceMock.getSublistOfHistory(plantmoodhistories).size();) {
            totalHealth += (plantmoodhistories.get(i).getHealth() * multiplier);
            substractionOfAverage += multiplier;
            multiplier -= 0.2;
            i++;
        }

        average = totalHealth / substractionOfAverage;

        //Act
        double expected = average;
        double actual = plantmoodServiceMock.calculateAverageHistory(plantmoodhistories);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getPlantmoodByIdTest() {
        //Act
        int expected = plantmoods.get(0).getId();
        int actual = plantmoodServiceMock.getPlantmoodById(1).getId();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAllPlantmoodsTest() {
        //Act
        int expected = plantmoods.size();
        int actual = plantmoodServiceMock.getAllPlantmoods().size();

        //Assert
        assertEquals(expected, actual);
    }
}