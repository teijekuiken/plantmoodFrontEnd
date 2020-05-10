package com.oopa.domain.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttService {

    private PlantmoodHistoryService plantmoodHistoryService;
    private static Logger logger = LoggerFactory.getLogger(PlantmoodHistoryService.class);

    public void splitMessage(String incommingMessage){
        String[] splitMessage = incommingMessage.split(",");
        String arduinoSn = splitMessage[0];
        int moistureValue = Integer.parseInt(splitMessage[1]);

        plantmoodHistoryService.addHistory(arduinoSn, moistureValue);
        logger.info("Received: ArduinoSn {} with moisturevalue of {}", arduinoSn, moistureValue);
    }
}
