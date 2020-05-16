package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.Plantmood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantmoodRepository extends JpaRepository<Plantmood, Integer> {
}
