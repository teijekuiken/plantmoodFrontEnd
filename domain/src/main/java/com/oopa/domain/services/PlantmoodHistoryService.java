package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.PlantmoodHistoryRepository;
import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantmoodHistoryService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlantmoodHistoryRepository plantmoodHistoryRepository;

    public PlantmoodHistory addHistory(PlantmoodHistory plantmoodHistory){
        System.out.println("testAddHistory: "+plantmoodHistory.getArduinoSn()+" "+plantmoodHistory.getHealth());
        var plantmoodHistoryEntity = this.modelMapper.map(plantmoodHistory, com.oopa.dataAccess.model.PlantmoodHistory.class);
        System.out.println("testEntity: "+plantmoodHistoryEntity.getArduinoSn()+" "+plantmoodHistoryEntity.getHealth());
        return this.modelMapper.map(plantmoodHistoryRepository.save(plantmoodHistoryEntity), PlantmoodHistory.class);
    }

    public List<PlantmoodHistory> getAllPlantmoodHistorties(){
        return plantmoodHistoryRepository.findAll().stream()
                .map(plantmoodHistory -> this.modelMapper.map(plantmoodHistory, PlantmoodHistory.class))
                .collect(Collectors.toList());
    }

    public PlantmoodHistory deletePlantmoodHistory(Integer id) {
        var plantmoodHistory = plantmoodHistoryRepository.findById(id);
        if (plantmoodHistory.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + PlantmoodHistory.class.getName() + " with id " + id);
        }

        plantmoodHistoryRepository.deleteById(id);

        return this.modelMapper.map(plantmoodHistory, PlantmoodHistory.class);
    }

    public PlantmoodHistory getPlantmoodHistoryById(Integer id) {
        var plantmoodHistory = plantmoodHistoryRepository.findById(id);

        return this.modelMapper.map(plantmoodHistory, PlantmoodHistory.class);
    }

    public List<IPlantmoodhistory> getAllHistoryByArduinoSn(String arduinoSn){
        return plantmoodHistoryRepository.findAllByArduinoSn(arduinoSn);
    }

}
