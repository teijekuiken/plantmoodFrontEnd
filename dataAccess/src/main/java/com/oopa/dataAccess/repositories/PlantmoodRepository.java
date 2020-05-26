package com.oopa.dataAccess.repositories;

import com.oopa.dataAccess.model.Plantmood;
import com.oopa.interfaces.model.IPlantmood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantmoodRepository extends JpaRepository<Plantmood, Integer> {

    IPlantmood findByArduinoSn(String arduinoSn);
}
