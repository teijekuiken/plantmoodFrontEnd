package com.oopa.domain.Service;

import com.oopa.domain.model.PlantSpecies;
import com.oopa.domain.model.Plantmood;
import com.oopa.domain.model.User;
import com.oopa.domain.services.PlantmoodService;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantMoodServiceTest {

    private PlantmoodService plantMoodService = new PlantmoodService();

    @Test
    void createPlantMood() {
        // arrange
        String name = "PlantMood1";
        IUser user = new User();
        String adruinoId = "ARDUINO1";
        int health = 40;

        // act + assert
        //assertDoesNotThrow(() -> plantMoodService.createPlantmood(name, health, user, adruinoId));

    }

    @Test
    void linkPlantMoodToPlantSpecie() {
/*        // arrange
        IPlantmood plantMood = new Plantmood();
        IPlantSpecies plantSpecie = new PlantSpecies("cactus", 450, 550);

        // act
        plantMood.setPlantSpecies(plantSpecie);

        // assert

        assertEquals(plantSpecie, plantMood.getPlantSpecies());*/

    }

    @Test
    void deletePlantMoodFromUser() {
        // arrange
        IPlantmood plantMood = new Plantmood();
        IUser user = new User();

        // act
        //plantMoodService.deletePlantmoodFromUser(plantMood, user);

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
        //plantMoodService.switchPlantmoodUser(plantMood, user1, user2);

        // assert
        assertEquals(user2, plantMood.getUser());
    }
}