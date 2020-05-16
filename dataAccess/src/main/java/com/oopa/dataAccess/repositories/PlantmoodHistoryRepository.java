package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantmoodHistoryRepository extends JpaRepository<PlantmoodHistory, Integer> {

    List<IPlantmoodhistory> findAllByArduinoSn(String arduinoSn);
}
