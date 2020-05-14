package com.oopa.dataAccess.repositories;

import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantmoodHistoryRepository extends CrudRepository <IPlantmoodhistory, Integer> {

    List<IPlantmoodhistory> findAllByArduinoSn(String arduinoSn);
}
