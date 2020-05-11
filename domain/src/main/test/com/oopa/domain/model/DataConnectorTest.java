package com.oopa.domain.model;

import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import com.oopa.interfaces.model.IPlantSpecies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataConnectorTest {

    IPlantmood plantMood = new Plantmood();
    IPlantmoodhistory history = new PlantmoodHistory( "Pietje",45 );
    IPlantSpecies wietplant = new PlantSpecies("cactus", 450, 550);
    DataConnector dataConnector = new DataConnector();

    @Test
    void convertPlantHealthToMood() {
        //arrage
        plantMood.setHealth(100);
        wietplant.setMinHumidity(200);
        String expected = "Too Dry";

        ///act
        String actualMood = dataConnector.ConvertPlantHealthToMood();

        //assert
        assertEquals(actualMood, expected);
    }

    @Test
    void convertPlantHealthToMood2() {
        //arrage
        plantMood.setHealth(300);
        wietplant.setMaxHumidity(200);
        String expected = "Too Wet";

        ///act
        String actualMood = dataConnector.ConvertPlantHealthToMood();

        //assert
        assertEquals(actualMood, expected);
    }

    @Test
    void convertPlantHealthToMood3() {
        //arrage
        plantMood.setHealth(300);
        wietplant.setMaxHumidity(700);
        wietplant.setMinHumidity(100);
        String expected = "Everything OKAY!";

        ///act
        String actualMood = dataConnector.ConvertPlantHealthToMood();

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