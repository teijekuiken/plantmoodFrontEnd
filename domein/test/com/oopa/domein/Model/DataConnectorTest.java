package com.oopa.domein.Model;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantMoodHistory;
import com.oopa.interfaces.model.IPlantSpecies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataConnectorTest {

    IPlantMood plantMood = new PlantMood();
    IPlantMoodHistory history = new PlantMoodHistory();
    IPlantSpecies wietplant = new PlantSpecies();
    DataConnector dataConnector = new DataConnector();

    @Test
    void convertPlantHealthToMood() {
        //arrage
        plantMood.setHealth(100);
        wietplant.setMinHumidity(200);
        String expected = "Too Dry";

        ///act
        String actualMood = dataConnector.ConvertPlantHealthToMood(plantMood, wietplant);

        //assert
        assertEquals(actualMood, expected);
    }

    @Test
    void convertPlantHealthToMood() {
        //arrage
        plantMood.setHealth(300);
        wietplant.setMaxHumidity(200);
        String expected = "Too Wet";

        ///act
        String actualMood = dataConnector.ConvertPlantHealthToMood(plantMood, wietplant);

        //assert
        assertEquals(actualMood, expected);
    }

    @Test
    void convertPlantHealthToMood() {
        //arrage
        plantMood.setHealth(300);
        wietplant.setMaxHumidity(700);
        wietplant.setMinHumidity(100);
        String expected = "Everything OKAY!";

        ///act
        String actualMood = dataConnector.ConvertPlantHealthToMood(plantMood, wietplant);

        //assert
        assertEquals(actualMood, expected);
    }


    @Test
    void receivePlantMoodData() {
        //arrange
        plantMood.setHealth(250);

        //act
        int actualHealth = dataConnector.ReceivePlantMoodData();
        int expectedHealth = plantMood.getHealth();

        //assert
        assertEquals(actualHealth, expectedHealth);
    }
}