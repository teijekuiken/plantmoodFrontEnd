package com.oopa.domain.mqtt;

import com.oopa.interfaces.mqtt.IMqtt;
import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mqtt implements IMqtt {

    private static Logger logger = LoggerFactory.getLogger(Mqtt.class);

    //--Enter your local ip where Mosquitto is running--
    private String mqttClient = "tcp://192.168.192.30";
    private String clientId = "Plantmood-CentralSystem";
    private IMqttAsyncClient client = new MqttAsyncClient(mqttClient, clientId);

    public Mqtt() throws MqttException {
    }

    public void startMqtt() throws MqttException {
        String incommingTopic = "Plantmood/AllPlantMoods/Data";
        client.setCallback(new Callback());
        client.connect().waitForCompletion();
        logger.info("Connected to MQTT broker");
        //--Subscribe to incoming messages from every Plantmood
        client.subscribe(incommingTopic,0);
    }

    public void sendMoodToPlantMood(String arduinoSn, String mood) throws MqttException {
        String outgoingTopic = "Plantmood/"+arduinoSn+"/Mood";
        client.publish(outgoingTopic, new MqttMessage(mood.getBytes()));
        logger.info("Published mood: {} to Plantmood: {}", mood, arduinoSn);
    }
}
