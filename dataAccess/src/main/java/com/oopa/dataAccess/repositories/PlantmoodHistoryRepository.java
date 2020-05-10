package com.oopa.dataAccess.repositories;

import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantmoodHistoryRepository extends CrudRepository <IPlantmoodhistory, Integer> {
}
