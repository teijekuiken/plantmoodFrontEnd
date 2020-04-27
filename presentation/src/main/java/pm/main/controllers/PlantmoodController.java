package pm.main.controllers;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IUser;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.PlantMood;
import pm.main.domain.User;

import java.nio.file.Path;
import java.util.List;

@RequestMapping("api/v1/plantmood")
@RestController
public class PlantmoodController {
    private PlantmoodService plantmoodService;

    public PlantmoodController(){
        this.plantmoodService = new PlantmoodService();
    }

    @PostMapping
    public void addPlantMood(@RequestBody IPlantMood plantMood){
        plantmoodService.addPlantMood(plantMood);
    }

    @GetMapping
    public List<IPlantMood> getAllPlantMood(){
        List<IPlantMood> plantMoods = plantmoodService.getAllPlantMood();
        return plantMoods;
    }

    @GetMapping(path = {"id"})
    public IPlantMood getPlantMoodById(@PathVariable("id") int id){
        IPlantMood plantMood = plantmoodService.getPlantMoodById(id);
        return plantMood;
    }

    @PutMapping
    public void updatePlantMood(IPlantMood plantMood){
        plantmoodService.updatePlantMood(plantMood);
    }

    @DeleteMapping
    public void deletePlantMood(int id){
        plantmoodService.deletePlantMood(id);
    }



}
