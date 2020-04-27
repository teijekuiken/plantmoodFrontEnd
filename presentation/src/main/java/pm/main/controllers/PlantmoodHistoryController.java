package pm.main.controllers;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IPlantMoodHistory;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.PlantMoodHistory;

import java.util.List;

@RequestMapping("api/v1/plantmoodhistory")
@RestController
public class PlantmoodHistoryController {

    private PlantmoodHistoryService plantmoodHistoryService;

    public PlantmoodHistoryController(){
        this.plantmoodHistoryService = new PlantmoodHistoryService();
    }


    //Wil je handmatig resultaten kunnen toevoegen vanuit de frontend?
    @PostMapping
    public void addPlantMoodReading(@RequestBody IPlantMoodHistory plantmoodhistory){

    }

    @GetMapping
    public List<IPlantMoodHistory> getAllPlantMoodHistory() {
        List<IPlantMoodHistory> histories = plantmoodHistoryService.getAllPlantMoodHistory();
        return histories;
    }

    @GetMapping(path = {"id"})
    public IPlantMoodHistory getPlantMoodHistoryById(@PathVariable("id") int id ){
        IPlantMoodHistory history = plantmoodHistoryService.getPlantMoodHistoryById(id);
        return history;
    }

    //Willen we op basis van een percentage de hele PlantMoodHistory op kunnen halen? Wat voegt dit toe aan de applicatie?
    @GetMapping(path = {"health"})
    public List<IPlantMoodHistory> getAllPlantMoodHistoryByHealth(@PathVariable("health") int health){
        return null;
    }

    @DeleteMapping
    public void deletePlantMoodHistory(int id){
        plantmoodHistoryService.deletePlantMoodHistory(id);
    }
}
