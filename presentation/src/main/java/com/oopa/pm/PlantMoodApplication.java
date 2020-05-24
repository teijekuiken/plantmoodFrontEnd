package com.oopa.pm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication(scanBasePackages = "com.oopa")
@EnableJpaRepositories("com.oopa.dataAccess.repositories")
@EntityScan("com.oopa.dataAccess.model")
public class PlantMoodApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(PlantMoodApplication.class).run();
        ApplicationConfiguration.MyGateway gateway = context.getBean(ApplicationConfiguration.MyGateway.class);
        gateway.sendToMqtt(MessageBuilder.withPayload("Dry").setHeader(MqttHeaders.TOPIC, "Plantmood/Alain/Mood").build());
        gateway.sendToMqtt(MessageBuilder.withPayload("Alive").setHeader(MqttHeaders.TOPIC, "Plantmood/Menno/Mood").build());
    }
}
