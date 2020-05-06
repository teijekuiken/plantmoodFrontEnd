package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.PlantmoodHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantmoodHistoryRepository extends CrudRepository<PlantmoodHistory, Integer> {
}
