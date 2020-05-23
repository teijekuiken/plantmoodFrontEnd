package com.oopa.domain.services;

import com.oopa.domain.model.PlantmoodHistory;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;
    private static Logger logger = LoggerFactory.getLogger(PlantmoodHistoryService.class);

    public void splitMessage(Message<?> incommingMessage){
        String[] splitMessage = incommingMessage.toString().split("[=,]");

        String arduinoSn = splitMessage[1];
        int moistureValue = Integer.parseInt(splitMessage[2]);

        PlantmoodHistory plantmoodHistory = new PlantmoodHistory();
        plantmoodHistory.setArduinoSn(arduinoSn);
        plantmoodHistory.setHealth(moistureValue);

        plantmoodHistoryService.addHistory(plantmoodHistory);
        logger.info("Received: ArduinoSn {} with moisturevalue of {}", plantmoodHistory.getArduinoSn(), plantmoodHistory.getHealth());
    }

    public void sendMoodToPlantMood(String arduinoSn, String mood) throws MqttException {
        String outgoingTopic = "Plantmood/"+arduinoSn+"/Mood";
        logger.info("Published mood: {} to Plantmood: {}", mood, arduinoSn);
    }

}
