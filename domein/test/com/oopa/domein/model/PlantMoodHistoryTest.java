package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantmoodhistory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlantMoodHistoryTest {

    final List<IPlantmoodhistory> plantMoodHistoryList = new ArrayList<>();
    final int expected = 1;
    final int health = 45;
    final String arduinoSn = "PlantMood-1";

    @Test
    public void addHistory() {
        //arrange
        plantMoodHistoryList.add(new PlantmoodHistory(health,arduinoSn));

        //act
        int actual = plantMoodHistoryList.size();

        //assert
        assertEquals(actual, expected);
    }
}