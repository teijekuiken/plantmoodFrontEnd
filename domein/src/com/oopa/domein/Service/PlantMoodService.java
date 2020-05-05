package com.oopa.domein.Service;

import com.oopa.domein.Model.PlantMood;
import com.oopa.domein.Model.User;
import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IUser;

public class PlantMoodService {

    protected PlantMood createPlantMood(String name, int health, IUser user, String arduinoId)
    {
        return new PlantMood();
    }

    protected PlantMood linkPlantMoodToPlantSpecie()
    {
        return new PlantMood();
    }

    protected void deletePlantMoodFromUser(IPlantMood plantMood, IUser user)
    {

    }

    protected PlantMood switchPlantMoodUser(IPlantMood plantMood, IUser currentUser, IUser newUser)
    {
        return new PlantMood();
    }

}
