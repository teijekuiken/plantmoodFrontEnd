package com.oopa.data.Model;

import com.oopa.interfaces.model.IPlantSpecies;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlantSpeciesTest {
    List<IPlantSpecies> plantSpeciesList = new ArrayList<>();

    IPlantSpecies plant1 = new PlantSpecies("Citrusboom", 500, 800);
    IPlantSpecies plant2 = new PlantSpecies("Pannenkoekenplant", 300, 900);

    @Test
    void addPlantSpieces1() {
        //Arrange
        plantSpeciesList.add(plant1);
        plantSpeciesList.add(plant2);

        //Act
        int actualLength = 2;

        //Assert
        assertEquals(actualLength, plantSpeciesList.size());
    }

    @Test
    void addPlantSpieces2() {
        //Arrange
        plantSpeciesList.add(plant1);
        plantSpeciesList.add(plant2);

        String inSearchOfName = plant2.getName();
        IPlantSpecies expected = null;

        //Act
        IPlantSpecies actual = plant2;

        for (IPlantSpecies plantSpecies : plantSpeciesList)  {
            if (plantSpecies.getName().equals(inSearchOfName)) {
                expected = plantSpecies;
            }
        }

        //Assert
        assertEquals(expected, actual);

    }
}