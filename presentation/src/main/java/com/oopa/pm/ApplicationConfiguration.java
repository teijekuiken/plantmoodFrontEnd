package com.oopa.pm;

import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean(name = "modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Value("${oopa.mqtt.client}")
    private String mqttClient;

    @Value("${oopa.mqtt.client.id}")
    private String clientId;

    @Bean
    public IMqttAsyncClient client() throws MqttException {
        return new MqttAsyncClient(mqttClient, clientId);
    }
}
