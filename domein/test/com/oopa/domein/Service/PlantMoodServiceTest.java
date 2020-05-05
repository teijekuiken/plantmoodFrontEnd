package com.oopa.domein.Service;

import com.oopa.domein.Model.PlantMood;
import com.oopa.domein.Model.PlantSpecies;
import com.oopa.domein.Model.User;
import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantMoodServiceTest {

    private PlantMoodService plantMoodService = new PlantMoodService();

    @Test
    void createPlantMood() {
        // arrange
        String name = "PlantMood1";
        User user = new User();
        String adruinoId = "ARDUINO1";
        int health = 40;

        // act + assert
        assertDoesNotThrow(() -> plantMoodService.createPlantMood(name, health, user, adruinoId));

    }

    @Test
    void linkPlantMoodToPlantSpecie() {
        // arrange
        IPlantMood plantMood = new PlantMood();
        IPlantSpecies plantSpecie = new PlantSpecies();

        // act
        plantMood.setPlantSpecies(plantSpecie);

        // assert

        assertEquals(plantSpecie, plantMood.getPlantSpecies());

    }

    @Test
    void deletePlantMoodFromUser() {
        // arrange
        IPlantMood plantMood = new PlantMood();
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
        IPlantMood plantMood = new PlantMood();
        plantMood.setUser(user1);

        // act
        plantMoodService.switchPlantMoodUser(plantMood, user1, user2);

        // assert
        assertEquals(user2, plantMood.getUser());
    }
}