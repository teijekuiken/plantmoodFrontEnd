package com.oopa.pm.controllers;

import com.oopa.domain.model.PlantSpecies;
import com.oopa.domain.services.PlantSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/plantspecies")
@RestController
public class PlantspeciesController {

    @Autowired
    private PlantSpeciesService plantspeciesService;

    @PostMapping
    public @ResponseBody PlantSpecies addPlantSpecies(@RequestBody PlantSpecies plantSpecies){
        return plantspeciesService.addPlantSpecies(plantSpecies);
    }

    @GetMapping
    public @ResponseBody List<PlantSpecies> getAllPlantSpecies(){
        return plantspeciesService.getAllPlantSpecies();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody PlantSpecies getPlantSpeciesById(@PathVariable("id") int id){
        return plantspeciesService.getPlantSpeciesById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deletePlantSpecies(@PathVariable Integer id){
        plantspeciesService.deletePlantSpecies(id);
        return "Plantspecies is deleted";
    }
}
