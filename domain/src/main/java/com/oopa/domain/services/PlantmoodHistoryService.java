package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmoodhistory;
import java.util.List;

public class PlantmoodHistoryService {

    private PlantmoodHistoryRepository plantmoodHistoryRepository;

    public void addHistory(String arduinoSn, int health){
        plantmoodHistoryRepository.save(new PlantmoodHistory(arduinoSn,health));
    }

    public List<IPlantmoodhistory> getAllHistoryByArduinoSn(String arduinoSn){
        return plantmoodHistoryRepository.findAllByArduinoSn(arduinoSn);
    }

    public List<IPlantmoodhistory> getAllPlantmoodHistory(){
        return (List<IPlantmoodhistory>) plantmoodHistoryRepository.findAll();
    }
}
