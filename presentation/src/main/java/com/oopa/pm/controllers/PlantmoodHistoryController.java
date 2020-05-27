package com.oopa.pm.controllers;

import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.domain.services.PlantmoodHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/plantmoodhistory")
@RestController
public class PlantmoodHistoryController {

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;

    @PostMapping
    public @ResponseBody PlantmoodHistory addHistory(@RequestBody PlantmoodHistory plantmoodHistory){
        return plantmoodHistoryService.addHistory(plantmoodHistory);
    }
}
