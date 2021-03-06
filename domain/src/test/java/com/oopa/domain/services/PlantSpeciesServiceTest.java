package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantSpeciesRepository;
import com.oopa.domain.PlantSpeciesServiceTestConfig;
import com.oopa.domain.model.PlantSpecies;
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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = PlantSpeciesService.class)
@Import({PlantSpeciesServiceTestConfig.class})
class PlantSpeciesServiceTest {

    List<com.oopa.dataAccess.model.PlantSpecies> plantSpecies = new ArrayList<>();

    @BeforeEach
    public void setup() {
        PlantSpecies tulip = new PlantSpecies();
        tulip.setId(1);
        tulip.setMinHumidity(200);
        tulip.setMaxHumidity(400);
        tulip.setName("Tulip");

        this.plantSpecies.add(this.modelMapper.map(tulip, com.oopa.dataAccess.model.PlantSpecies.class));

        Mockito.when(plantSpeciesRepository.findById(tulip.getId())).thenReturn(
                Optional.of(this.modelMapper.map(tulip, com.oopa.dataAccess.model.PlantSpecies.class))
        );

        Mockito.when(plantSpeciesRepository.findAll()).thenReturn(
                plantSpecies
        );
    }

    @MockBean
    private PlantSpeciesRepository plantSpeciesRepository;

    @Autowired
    private PlantSpeciesService plantSpeciesServiceMock;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void CheckPlantSpeciesServiceForExceptionsTest() {
        //Arrange
        int unknownId = 0;

        //Assert
        assertThrows(EntityNotFoundException.class, () -> {plantSpeciesServiceMock.getPlantSpeciesById(unknownId);
        });
    }

    @Test
    void getAllPlantSpecies() {
        //Arrange


        //Act
        int expected = this.plantSpecies.size();
        int actual = plantSpeciesServiceMock.getAllPlantSpecies().size();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void getPlantSpeciesById() {
        //Act
        String expected = plantSpecies.get(0).getName();
        String actual = plantSpeciesServiceMock.getPlantSpeciesById(1).getName();

        //Assert
        assertEquals(expected, actual);
    }
}