package com.oopa.pm.controllers;

import com.oopa.domain.model.Plantmood;
import com.oopa.domain.services.PlantmoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/plantmood")
@RestController
public class PlantmoodController {
    @Autowired
    private PlantmoodService plantmoodService;

    @PostMapping
    public @ResponseBody Plantmood addPlantMood(@RequestBody Plantmood plantmood){
        return plantmoodService.addPlantmood(plantmood);
    }

    @GetMapping
    public @ResponseBody List<Plantmood> getAllPlantMood(){
        return plantmoodService.getAllPlantmoods();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Plantmood getPlantMoodById(@PathVariable("id") Integer id){
        return plantmoodService.getPlantmoodById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody Plantmood deletePlantMood(@PathVariable Integer id){
        return plantmoodService.deletePlantmood(id);
    }
}
