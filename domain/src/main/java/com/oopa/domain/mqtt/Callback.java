package com.oopa.domain.mqtt;

import com.oopa.domain.services.MqttService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Callback implements MqttCallback {

    private MqttService mqttService;

    @Override
    public void connectionLost(Throwable throwable){
        // TODO: 27/04/2020 add logger instead of println
        System.out.println("Connection to MQTT broker is lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage){
        String incommingMessage = new String(mqttMessage.getPayload());
        mqttService.splitMessage(incommingMessage);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken){
        //--Not used for now--
    }
}
