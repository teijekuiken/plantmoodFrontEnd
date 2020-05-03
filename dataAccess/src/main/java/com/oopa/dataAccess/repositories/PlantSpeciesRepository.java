package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.PlantSpecies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSpeciesRepository extends CrudRepository<PlantSpecies, Integer> {
}
