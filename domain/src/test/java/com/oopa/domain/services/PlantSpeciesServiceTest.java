package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantSpeciesRepository;
import com.oopa.domain.TestConfig;
import com.oopa.domain.model.PlantSpecies;
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

@SpringBootTest(classes = PlantSpeciesService.class)
@Import({TestConfig.class})
class PlantSpeciesServiceTest {

    @BeforeEach
    public void setup() {
        List<com.oopa.dataAccess.model.PlantSpecies> plantSpecies = new ArrayList<>();
        PlantSpecies tulip = new PlantSpecies();
        tulip.setId(1);
        tulip.setMinHumidity(200);
        tulip.setMaxHumidity(400);
        tulip.setName("Tulip");

        plantSpecies.add(this.modelMapper.map(tulip, com.oopa.dataAccess.model.PlantSpecies.class));

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
    void addPlantSpecies() {
    }

    @Test
    void getAllPlantSpecies() {
        List<PlantSpecies> foundPlantSpecies = plantSpeciesServiceMock.getAllPlantSpecies();

        assertEquals("Tulip", foundPlantSpecies.get(0).getName());
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