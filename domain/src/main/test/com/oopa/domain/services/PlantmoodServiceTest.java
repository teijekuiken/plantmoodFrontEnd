package com.oopa.domain.services;

import com.oopa.dataAccess.model.FakePlantmoodHistory;
import com.oopa.dataAccess.model.FakePlantspecies;
import com.oopa.dataAccess.repositories.FakePlantmoodHistoriesDAO;
import com.oopa.dataAccess.repositories.FakePlantspeciesDAO;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PlantmoodServiceTest {

    @Test
    void getPlantStatus() {
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


        //Act
        System.out.println(fakePlantmoodHistoriesDAO.getAllFakePlantmoodHistories());
        System.out.println(fakePlantspeciesDAO.getAllPlantspecies());
        plantmoodService.getPlantStatus(fakePlantmoodHistoriesDAO.getAllFakePlantmoodHistories(), fakePlantspecies);

        //Assert
        
    }
}