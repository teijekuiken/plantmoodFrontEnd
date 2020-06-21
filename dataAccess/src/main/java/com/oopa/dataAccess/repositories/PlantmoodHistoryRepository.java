package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantSpecies;
import com.oopa.interfaces.model.IPlantmood;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantmoodHistoryRepository extends JpaRepository<PlantmoodHistory, Integer> {
    List<IPlantmoodhistory> findAllByArduinoSn(String arduinoSn);

    @Query(value = "SELECT * FROM plantmood_history WHERE arduino_sn = ?1 ORDER BY date DESC LIMIT 1",
            nativeQuery = true)
    Optional<PlantmoodHistory> findLatestPlantmoodHistoryByArduinoSn(String arduinoSn);

    @Query(value = "SELECT * FROM plantmood_history WHERE arduino_sn = ?1 ORDER BY date DESC LIMIT 10",
            nativeQuery = true)
    List<PlantmoodHistory> findLastTenPlantmoodHistoriesByArduinoSn(String arduinoSn);
}
