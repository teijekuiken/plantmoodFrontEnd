package com.oopa.dataAccess.repositories;

import com.oopa.interfaces.model.IPlantSpecies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSpeciesRepository extends CrudRepository<IPlantSpecies, Integer> {
}
