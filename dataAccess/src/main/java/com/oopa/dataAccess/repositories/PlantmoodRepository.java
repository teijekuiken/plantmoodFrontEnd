package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantmoodRepository extends CrudRepository<IPlantmood, Integer> {
}
