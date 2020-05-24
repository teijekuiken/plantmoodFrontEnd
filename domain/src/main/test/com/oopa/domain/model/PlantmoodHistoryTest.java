//package com.oopa.domain.model;
//
//import com.oopa.interfaces.model.IPlantmoodhistory;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PlantmoodHistoryTest {
//
//    final List<IPlantmoodhistory> plantmoodHistoryList = new ArrayList<>();
//    final int expected = 1;
//    final int health = 45;
//    final String arduinoSn = "PlantMood-1";
//
//    @Test
//    public void addHistory() {
//        //arrange
//        plantmoodHistoryList.add(new PlantmoodHistory(arduinoSn,health));
//
//        //act
//        int actual = plantmoodHistoryList.size();
//
//        //assert
//        assertEquals(actual, expected);
//    }
//}