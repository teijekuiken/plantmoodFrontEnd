package pm.main.controllers;

import com.oopa.interfaces.model.IPlantmoodhistory;
import org.springframework.web.bind.annotation.*;

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
    public void addPlantMoodReading(@RequestBody IPlantmoodhistory plantmoodhistory){

    }

    @GetMapping
    public List<IPlantmoodhistory> getAllPlantMoodHistory() {
        List<IPlantmoodhistory> histories = plantmoodHistoryService.getAllPlantMoodHistory();
        return histories;
    }

    @GetMapping(path = {"id"})
    public IPlantmoodhistory getPlantMoodHistoryById(@PathVariable("id") int id ){
        IPlantmoodhistory history = plantmoodHistoryService.getPlantMoodHistoryById(id);
        return history;
    }

    //Willen we op basis van een percentage de hele PlantmoodHistory op kunnen halen? Wat voegt dit toe aan de applicatie?
    @GetMapping(path = {"health"})
    public List<IPlantmoodhistory> getAllPlantMoodHistoryByHealth(@PathVariable("health") int health){
        return null;
    }

    @DeleteMapping
    public void deletePlantMoodHistory(int id){
        plantmoodHistoryService.deletePlantMoodHistory(id);
    }
}
