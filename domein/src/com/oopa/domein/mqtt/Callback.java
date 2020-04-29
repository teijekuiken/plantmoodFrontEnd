package com.oopa.domein.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Callback implements MqttCallback {


    @Override
    public void connectionLost(Throwable throwable){
        // TODO: 27/04/2020 add logger instead of println
        System.out.println("Connection to MQTT broker is lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage){
        String message = new String(mqttMessage.getPayload());

        //--Split incomming message in seperate variables--
        String[] splitMessage = message.split(",");
        String arduinoSn = splitMessage[0];
        String moistureValue = splitMessage[1];

        // TODO: 27/04/2020 add method to dataAcces layer
        //new createPlantMoodHistory(arduinoSn, moistureValue);
        System.out.println(arduinoSn+" "+moistureValue);

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken){
        //--Not used for now--
    }
}
