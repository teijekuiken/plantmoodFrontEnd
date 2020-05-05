package com.oopa.domein.services;

public class MqttService {

    private PlantmoodHistoryService plantmoodHistoryService;

    public void splitMessage(String incommingMessage){
        String[] splitMessage = incommingMessage.split(",");
        String arduinoSn = splitMessage[0];
        int moistureValue = Integer.parseInt(splitMessage[1]);

        plantmoodHistoryService.addHistory(arduinoSn, moistureValue);

        // TODO: 05/05/2020 add logger instead of println for verification with database
        System.out.println(arduinoSn+" "+moistureValue);
    }
}
