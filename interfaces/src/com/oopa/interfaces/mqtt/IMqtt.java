package com.oopa.interfaces.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface IMqtt {

    void startMqtt() throws MqttException;
    void sendMoodToPlantMood(String arduinoSn, String mood) throws MqttException;
}
