package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.Plantmood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantmoodRepository extends CrudRepository<Plantmood, Integer> {
}
