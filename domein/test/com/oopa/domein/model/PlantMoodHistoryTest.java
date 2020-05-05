package com.oopa.domein.model;

import com.oopa.interfaces.model.IPlantMoodHistory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlantMoodHistoryTest {

    final List<IPlantMoodHistory> plantMoodHistoryList = new ArrayList<>();
    final int expected = 1;
    final int health = 45;
    final String arduinoSn = "PlantMood-1";

    @Test
    public void addHistory() {
        //arrange
        plantMoodHistoryList.add(new PlantMoodHistory(health,arduinoSn));

        //act
        int actual = plantMoodHistoryList.size();

        //assert
        assertEquals(actual, expected);
    }
}