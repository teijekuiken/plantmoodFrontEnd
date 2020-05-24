package com.oopa.pm.controllers;

import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.domain.services.PlantmoodHistoryService;
import com.oopa.pm.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/plantmoodhistory")
@RestController
public class PlantmoodHistoryController {

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;

    @Autowired
    private ApplicationConfiguration config;

    @GetMapping
    public @ResponseBody List<PlantmoodHistory> getAllPlantMoodHistory() {
        return plantmoodHistoryService.getAllPlantmoodHistorties();
    }

    @GetMapping(path = {"id"})
    public @ResponseBody PlantmoodHistory getPlantMoodHistoryById(@PathVariable("id") Integer id ){
        return plantmoodHistoryService.getPlantmoodHistoryById(id);
    }

    @DeleteMapping
    public @ResponseBody PlantmoodHistory deletePlantMoodHistory(Integer id){
        return plantmoodHistoryService.deletePlantmoodHistory(id);
    }

    @PostMapping
    public @ResponseBody PlantmoodHistory addHistory(@RequestBody PlantmoodHistory plantmoodHistory){
        return plantmoodHistoryService.addHistory(plantmoodHistory);
    }

    @GetMapping(path = {"/mood"})
    public void sendToPlantmood(){
        config.mqttOutboundChannel().send(MessageBuilder.withPayload("Alive").setHeader(MqttHeaders.TOPIC, "Plantmood/Menno/Mood").build());
    }
}
