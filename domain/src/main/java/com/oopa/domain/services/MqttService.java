package com.oopa.domain.services;

import com.oopa.domain.model.PlantmoodHistory;
import com.oopa.interfaces.model.IPlantmoodhistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MqttService {

    private PlantmoodHistoryService plantmoodHistoryService;
    private static Logger logger = LoggerFactory.getLogger(PlantmoodHistoryService.class);

    public void splitMessage(String incommingMessage){
        String[] splitMessage = incommingMessage.split(",");
        String arduinoSn = splitMessage[0];
        int moistureValue = Integer.parseInt(splitMessage[1]);

        IPlantmoodhistory plantmoodHistory = plantmoodHistoryService.addHistory(new PlantmoodHistory(arduinoSn, moistureValue));
        logger.info("Received: ArduinoSn {} with moisturevalue of {}", plantmoodHistory.getArduinoSn(), plantmoodHistory.getHealth());
    }
}
