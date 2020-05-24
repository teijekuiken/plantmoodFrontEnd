package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.FakePlantmoodHistory;
import com.oopa.dataAccess.model.FakePlantspecies;
import com.oopa.dataAccess.model.PlantSpecies;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository("fakeDao")
public class FakePlantspeciesDAO {

    private static List<FakePlantspecies> DB = new ArrayList<>();


//    public FakePlantspecies addPlantspecies(FakePlantspecies fakePlantspecies) {
//        DB.add(new FakePlantspecies(1, "Tulip", 400, 800));
//        return fakePlantspecies;
//    }

    public void addPlantspecies(FakePlantspecies fakePlantspecies) {
        DB.add(fakePlantspecies);
    }

    public List<FakePlantspecies> getAllPlantspecies() {return DB;}

}
