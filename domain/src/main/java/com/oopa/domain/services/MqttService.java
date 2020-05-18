package com.oopa.domain.services;

import com.oopa.domain.model.PlantmoodHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;
    private static Logger logger = LoggerFactory.getLogger(PlantmoodHistoryService.class);

    public void splitMessage(String incommingMessage){
        String[] splitMessage = incommingMessage.split(",");
        String arduinoSn = splitMessage[0];
        Integer moistureValue = Integer.parseInt(splitMessage[1]);

        PlantmoodHistory plantmoodHistory = new PlantmoodHistory();
        plantmoodHistory.setArduinoSn(arduinoSn);
        plantmoodHistory.setHealth(moistureValue);

        plantmoodHistoryService.addHistory(plantmoodHistory);

        logger.info("Received: ArduinoSn {} with moisturevalue of {}", plantmoodHistory.getArduinoSn(), plantmoodHistory.getHealth());

    }
}
