package com.oopa.domain.services;

import com.oopa.domain.MqttConfiguration;
import com.oopa.domain.model.PlantmoodHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class MqttService {

    @Autowired
    private PlantmoodHistoryService plantmoodHistoryService;

    @Autowired
    private MqttConfiguration config;

    @Autowired
    private PlantmoodService plantmoodService;

    private static Logger logger = LoggerFactory.getLogger(PlantmoodHistoryService.class);

    public void splitMessage(Message<?> incommingMessage){
        String[] splitMessage = incommingMessage.toString().split("[=,]");
        String arduinoSn = splitMessage[1];
        int moistureValue = Integer.parseInt(splitMessage[2]);

        sendAndCheck(arduinoSn,moistureValue);
    }

    public void sendAndCheck(String arduinoSn, int moistureValue){
        Date date = new Date(System.currentTimeMillis());
        PlantmoodHistory plantmoodHistory = new PlantmoodHistory();
        plantmoodHistory.setArduinoSn(arduinoSn);
        plantmoodHistory.setHealth(moistureValue);
        plantmoodHistory.setCreatedAt(date);

        //Send to History
        plantmoodHistoryService.addHistory(plantmoodHistory);
        logger.info("Received: ArduinoSn {} with moisturevalue of {}", plantmoodHistory.getArduinoSn(), plantmoodHistory.getHealth());

        //Check status
        logger.info("Checking status of the plant connected to the Plantmood with arduinoSn {}", arduinoSn);
        checkPlantStatus(arduinoSn);
    }

    public void checkPlantStatus(String arduinoSn){
        plantmoodService.getPlantStatus(arduinoSn);
    }

    public void sendMoodToPlantMood(String arduinoSn, String mood){
        String outgoingTopic = "Plantmood/"+arduinoSn+"/Mood";
        config.mqttOutboundChannel().send(MessageBuilder.withPayload(mood).setHeader(MqttHeaders.TOPIC, outgoingTopic).build());
        logger.info("Published mood: {} to Plantmood: {}", mood, arduinoSn);
    }
}
