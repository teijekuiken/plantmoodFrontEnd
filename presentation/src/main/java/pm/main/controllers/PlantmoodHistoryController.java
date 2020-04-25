package pm.main.controllers;

import com.oopa.interfaces.model.IPlantMoodHistory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/plantmoodhistory")
@RestController
public class PlantmoodHistoryController {

    public PlantmoodHistoryController(){

    }

    @PostMapping
    public void addPlantMoodReading(IPlantMoodHistory plantmoodhistory){

    }

    @GetMapping
    public List<IPlantMoodHistory> getAllPlantMoodHistory() {
        return null;
    }

    @GetMapping(path = {"id"})
    public IPlantMoodHistory getPlantMoodHistoryById(@PathVariable("id") int id ){
        return null;
    }

    @GetMapping(path = {"health"})
    public List<IPlantMoodHistory> getAllPlantMoodHistoryByHealth(@PathVariable("health") int health){
        return null;
    }

    @DeleteMapping
    public void deletePlantMoodHistory(int id){

    }
}
