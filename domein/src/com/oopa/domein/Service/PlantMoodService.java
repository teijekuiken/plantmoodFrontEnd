package com.oopa.domein.Service;

import com.oopa.domein.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IUser;

public class PlantMoodService {

    protected Plantmood createPlantMood(String name, int health, IUser user, String arduinoId)
    {
        return new Plantmood();
    }

    protected Plantmood linkPlantMoodToPlantSpecie()
    {
        return new Plantmood();
    }

    protected void deletePlantMoodFromUser(IPlantmood plantMood, IUser user)
    {

    }

    protected Plantmood switchPlantMoodUser(IPlantmood plantMood, IUser currentUser, IUser newUser)
    {
        return new Plantmood();
    }

}
