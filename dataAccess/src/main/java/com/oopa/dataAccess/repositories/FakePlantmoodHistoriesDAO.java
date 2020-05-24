package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.FakePlantmoodHistory;
import com.oopa.dataAccess.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository("fakeDao")
public class FakePlantmoodHistoriesDAO {

    private static List<IPlantmoodhistory> DB = new ArrayList<>();

//    public FakePlantmoodHistory addHistory(FakePlantmoodHistory fakePlantmoodHistory) {
//        DB.add(new FakePlantmoodHistory(1, 400
//                , "Arduino: " + fakePlantmoodHistory.getId(), LocalDateTime.now()));
//        return fakePlantmoodHistory;
//    }

    public void addHistory(FakePlantmoodHistory fakePlantmoodHistory) {
        DB.add(fakePlantmoodHistory);
    }

    public List<IPlantmoodhistory> getAllFakePlantmoodHistories() {return DB;}


}
