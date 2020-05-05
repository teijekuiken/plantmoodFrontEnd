package pm;

import com.oopa.domein.mqtt.Mqtt;
import com.oopa.interfaces.mqtt.IMqtt;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
