package pm.main;

import com.oopa.domein.mqtt.Mqtt;
import com.oopa.interfaces.mqtt.IMqtt;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.oopa")
@EnableJpaRepositories("com.oopa.dataAccess.repositories")
@EntityScan("com.oopa.dataAccess.model")
public class PlantMoodApplication {
    public static void main(String[] args) throws MqttException {
        SpringApplication.run(PlantMoodApplication.class, args);
//        new Mqtt().startMqtt();
    }
}
