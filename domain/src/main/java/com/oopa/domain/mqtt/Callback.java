package com.oopa.domain.mqtt;

import com.oopa.domain.services.MqttService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Callback implements MqttCallback {

    private static Logger logger = LoggerFactory.getLogger(Callback.class);
    private Mqtt mqtt;
    private MqttService mqttService;

    @Override
    public void connectionLost(Throwable throwable){
        logger.error("Connection to MQTT broker is lost, reconnecting...");
        try {
            mqtt.startMqtt();
        } catch (MqttException e) {
            logger.error(e.toString());
        }
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
