package com.oopa.pm.controllers;

import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.domain.services.PlantmoodHistoryService;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/plantmoodhistory")
@RestController
public class PlantmoodHistoryController {

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;

    @GetMapping
    public @ResponseBody
    List<PlantmoodHistory> getAllHistory(){
        return plantmoodHistoryService.getAllPlantmoodHistorties();
    }

    @GetMapping(path = "/{arduinoSn}")
    public @ResponseBody List<IPlantmoodhistory> getSpecificHistory(@PathVariable("arduinoSn") String arduinoSn ){
        return plantmoodHistoryService.getAllHistoryByArduinoSn(arduinoSn);
    }
}
