package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmoodhistory;
import java.util.List;

public class PlantmoodHistoryService {

    private PlantmoodHistoryRepository plantmoodHistoryRepository;

    public void addHistory(String arduinoSn, int health){
        PlantmoodHistory plantmoodHistory = new PlantmoodHistory(arduinoSn,health);
        plantmoodHistoryRepository.save(plantmoodHistory);
    }

    public List<IPlantmoodhistory> getAllHistoryPerPlantMood(String arduinoSn){
        List<IPlantmoodhistory> allHistory = plantmoodHistoryRepository.findAllByArduinoSn(arduinoSn);
        return allHistory;
    }


}
