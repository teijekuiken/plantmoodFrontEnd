package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.PlantSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantSpeciesRepository extends JpaRepository<PlantSpecies, Integer> {
}
