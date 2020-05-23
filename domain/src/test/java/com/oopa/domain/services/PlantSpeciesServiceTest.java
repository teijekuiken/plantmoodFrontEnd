package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantSpeciesRepository;
import com.oopa.domain.TestConfig;
import com.oopa.domain.model.PlantSpecies;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PlantSpeciesService.class)
@Import({TestConfig.class})
class PlantSpeciesServiceTest {

    @Before
    public void setup() {
        PlantSpecies tulip = new PlantSpecies();
        tulip.setId(1);
        tulip.setMinHumidity(200);
        tulip.setMaxHumidity(400);
        tulip.setName("Tulip");

        Mockito.when(plantSpeciesRepository.findById(tulip.getId())).thenReturn(
                Optional.of(this.modelMapper.map(tulip, com.oopa.dataAccess.model.PlantSpecies.class))
        );
    }

    @MockBean
    private PlantSpeciesRepository plantSpeciesRepository;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private PlantSpeciesService plantSpeciesServiceMock;

    @Test
    void addPlantSpecies() {
    }

    @Test
    void getAllPlantSpecies() {
    }

    @Test
    void getPlantSpeciesById() {
        PlantSpecies foundPlantSpecies = plantSpeciesServiceMock.getPlantSpeciesById(1);

        assertEquals("Tulip", foundPlantSpecies.getName());
    }

    @Test
    void deletePlantSpecies() {
    }
}