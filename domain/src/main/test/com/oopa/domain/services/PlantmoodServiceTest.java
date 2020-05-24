package com.oopa.domain.services;

import com.oopa.dataAccess.model.FakePlantmoodHistory;
import com.oopa.dataAccess.model.FakePlantspecies;
import com.oopa.dataAccess.repositories.FakePlantmoodHistoriesDAO;
import com.oopa.dataAccess.repositories.FakePlantspeciesDAO;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PlantmoodServiceTest {

    @Test
    void getPlantStatus_WhereWaterLevelIsGood() {
        //Arrange
        PlantmoodService plantmoodService = new PlantmoodService();
        FakePlantmoodHistoriesDAO fakePlantmoodHistoriesDAO = new FakePlantmoodHistoriesDAO();
        FakePlantspeciesDAO fakePlantspeciesDAO = new FakePlantspeciesDAO();
        FakePlantspecies fakePlantspecies =
                new FakePlantspecies(1, "species1", 400, 800);
        FakePlantmoodHistory fakePlantmoodHistory1 =
                new FakePlantmoodHistory(1, 400, "#123"
                        , LocalDateTime.now().minusMinutes(15));
        FakePlantmoodHistory fakePlantmoodHistory2 =
                new FakePlantmoodHistory(2, 500, "#123"
                        , LocalDateTime.now().minusMinutes(14));
        FakePlantmoodHistory fakePlantmoodHistory3 =
                new FakePlantmoodHistory(3, 600, "#123"
                        , LocalDateTime.now().minusMinutes(13));
        FakePlantmoodHistory fakePlantmoodHistory4 =
                new FakePlantmoodHistory(4, 700, "#123"
                        , LocalDateTime.now().minusMinutes(12));
        FakePlantmoodHistory fakePlantmoodHistory5 =
                new FakePlantmoodHistory(5, 800, "#123"
                        , LocalDateTime.now().minusMinutes(11));
        fakePlantmoodHistoriesDAO.addHistory(fakePlantmoodHistory1);
        fakePlantmoodHistoriesDAO.addHistory(fakePlantmoodHistory2);
        fakePlantmoodHistoriesDAO.addHistory(fakePlantmoodHistory3);
        fakePlantmoodHistoriesDAO.addHistory(fakePlantmoodHistory4);
        fakePlantmoodHistoriesDAO.addHistory(fakePlantmoodHistory5);

        fakePlantspeciesDAO.addPlantspecies(fakePlantspecies);

        String expected = "De plant is op het juiste niveau";


        //Act
        System.out.println(fakePlantmoodHistoriesDAO.getAllFakePlantmoodHistories());
        System.out.println(fakePlantspeciesDAO.getAllPlantspecies());
        String actual = plantmoodService.getPlantStatus(
                fakePlantmoodHistoriesDAO.getAllFakePlantmoodHistories(),
                fakePlantspecies,
                LocalDateTime.now().minusMinutes(11));

        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void getPlantStatus_WhereWaterLevelIsTooHigh() {
        //Arrange
        PlantmoodService plantmoodService = new PlantmoodService();
        FakePlantmoodHistoriesDAO fakePlantmoodHistoriesDAO2 = new FakePlantmoodHistoriesDAO();
        FakePlantspeciesDAO fakePlantspeciesDAO = new FakePlantspeciesDAO();
        FakePlantspecies fakePlantspecies =
                new FakePlantspecies(1, "species1", 400, 800);
        FakePlantmoodHistory fakePlantmoodHistory1 =
                new FakePlantmoodHistory(1, 1100, "#123"
                        , LocalDateTime.now().minusMinutes(15));
        FakePlantmoodHistory fakePlantmoodHistory2 =
                new FakePlantmoodHistory(2, 1200, "#123"
                        , LocalDateTime.now().minusMinutes(14));
        FakePlantmoodHistory fakePlantmoodHistory3 =
                new FakePlantmoodHistory(3, 1300, "#123"
                        , LocalDateTime.now().minusMinutes(13));
        FakePlantmoodHistory fakePlantmoodHistory4 =
                new FakePlantmoodHistory(4, 1400, "#123"
                        , LocalDateTime.now().minusMinutes(12));
        FakePlantmoodHistory fakePlantmoodHistory5 =
                new FakePlantmoodHistory(5, 1500, "#123"
                        , LocalDateTime.now().minusMinutes(11));
        fakePlantmoodHistoriesDAO2.addHistory(fakePlantmoodHistory1);
        fakePlantmoodHistoriesDAO2.addHistory(fakePlantmoodHistory2);
        fakePlantmoodHistoriesDAO2.addHistory(fakePlantmoodHistory3);
        fakePlantmoodHistoriesDAO2.addHistory(fakePlantmoodHistory4);
        fakePlantmoodHistoriesDAO2.addHistory(fakePlantmoodHistory5);

        fakePlantspeciesDAO.addPlantspecies(fakePlantspecies);

        String expected = "Te veel water";


        //Act
        System.out.println(fakePlantmoodHistoriesDAO2.getAllFakePlantmoodHistories());
        System.out.println(fakePlantspeciesDAO.getAllPlantspecies());
        String actual = plantmoodService.getPlantStatus(
                fakePlantmoodHistoriesDAO2.getAllFakePlantmoodHistories(),
                fakePlantspecies,
                LocalDateTime.now().minusMinutes(11));

        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void getPlantStatus_WhereWaterLevelIsTooLow() {
        //Arrange
        PlantmoodService plantmoodService = new PlantmoodService();
        FakePlantmoodHistoriesDAO fakePlantmoodHistoriesDAO3 = new FakePlantmoodHistoriesDAO();
        FakePlantspeciesDAO fakePlantspeciesDAO = new FakePlantspeciesDAO();
        FakePlantspecies fakePlantspecies =
                new FakePlantspecies(1, "species1", 2000, 4000);
        FakePlantmoodHistory fakePlantmoodHistory1 =
                new FakePlantmoodHistory(1, 1100, "#123"
                        , LocalDateTime.now().minusMinutes(15));
        FakePlantmoodHistory fakePlantmoodHistory2 =
                new FakePlantmoodHistory(2, 1200, "#123"
                        , LocalDateTime.now().minusMinutes(14));
        FakePlantmoodHistory fakePlantmoodHistory3 =
                new FakePlantmoodHistory(3, 1300, "#123"
                        , LocalDateTime.now().minusMinutes(13));
        FakePlantmoodHistory fakePlantmoodHistory4 =
                new FakePlantmoodHistory(4, 1400, "#123"
                        , LocalDateTime.now().minusMinutes(12));
        FakePlantmoodHistory fakePlantmoodHistory5 =
                new FakePlantmoodHistory(5, 1500, "#123"
                        , LocalDateTime.now().minusMinutes(11));
        fakePlantmoodHistoriesDAO3.addHistory(fakePlantmoodHistory1);
        fakePlantmoodHistoriesDAO3.addHistory(fakePlantmoodHistory2);
        fakePlantmoodHistoriesDAO3.addHistory(fakePlantmoodHistory3);
        fakePlantmoodHistoriesDAO3.addHistory(fakePlantmoodHistory4);
        fakePlantmoodHistoriesDAO3.addHistory(fakePlantmoodHistory5);

        fakePlantspeciesDAO.addPlantspecies(fakePlantspecies);

        String expected = "Geef water";


        //Act
        System.out.println(fakePlantmoodHistoriesDAO3.getAllFakePlantmoodHistories());
        System.out.println(fakePlantspeciesDAO.getAllPlantspecies());
        String actual = plantmoodService.getPlantStatus(
                fakePlantmoodHistoriesDAO3.getAllFakePlantmoodHistories(),
                fakePlantspecies,
                LocalDateTime.now().minusMinutes(11));

        //Assert
        assertEquals(actual, expected);
    }
}