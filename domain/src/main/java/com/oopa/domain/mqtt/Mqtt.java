package com.oopa.domain.mqtt;

import com.oopa.interfaces.mqtt.IMqtt;
import org.eclipse.paho.client.mqttv3.*;

public class Mqtt implements IMqtt {

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

        //--Subscribe to incoming messages from every Plantmood
        client.subscribe(incommingTopic,0);
    }

    public void sendMoodToPlantMood(String arduinoSn, String mood) throws MqttException {
        String outgoingTopic = "Plantmood/"+arduinoSn+"/Mood";
        client.publish(outgoingTopic, new MqttMessage(mood.getBytes()));
    }
}
