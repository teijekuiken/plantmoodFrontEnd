package com.oopa.domein.Service;

import com.oopa.domein.model.PlantSpecies;
import com.oopa.domein.model.Plantmood;
import com.oopa.domein.model.User;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantMoodServiceTest {

    private PlantMoodService plantMoodService = new PlantMoodService();

    @Test
    void createPlantMood() {
        // arrange
        String name = "PlantMood1";
        IUser user = new User();
        String adruinoId = "ARDUINO1";
        int health = 40;

        // act + assert
        assertDoesNotThrow(() -> plantMoodService.createPlantMood(name, health, user, adruinoId));

    }

    @Test
    void linkPlantMoodToPlantSpecie() {
        // arrange
        IPlantmood plantMood = new Plantmood();
        IPlantSpecies plantSpecie = new PlantSpecies();

        // act
        plantMood.setPlantSpecies(plantSpecie);

        // assert

        assertEquals(plantSpecie, plantMood.getPlantSpecies());

    }

    @Test
    void deletePlantMoodFromUser() {
        // arrange
        IPlantmood plantMood = new Plantmood();
        IUser user = new User();

        // act
        plantMoodService.deletePlantMoodFromUser(plantMood, user);

        // assert
        assertNull(plantMood.getUser());
    }

    @Test
    void switchPlantMoodUser() {
        // arrange
        IUser user1 = new User();
        IUser user2 = new User();
        IPlantmood plantMood = new Plantmood();
        plantMood.setUser(user1);

        // act
        plantMoodService.switchPlantMoodUser(plantMood, user1, user2);

        // assert
        assertEquals(user2, plantMood.getUser());
    }
}