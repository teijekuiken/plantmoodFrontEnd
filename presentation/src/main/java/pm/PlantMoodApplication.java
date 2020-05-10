package pm;

import com.oopa.domain.mqtt.Mqtt;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.oopa")
@EnableJpaRepositories("com.oopa.dataAccess.repositories")
@EntityScan("com.oopa.dataAccess.model")
public class PlantMoodApplication {
    public static void main(String[] args){
        SpringApplication.run(PlantMoodApplication.class, args);
        try {
            new Mqtt().startMqtt();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
