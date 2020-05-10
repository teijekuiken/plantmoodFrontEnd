package pm.controllers;

import com.oopa.domain.services.PlantmoodService;
import com.oopa.interfaces.model.IPlantmood;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/plantmood")
@RestController
public class PlantmoodController {
    private PlantmoodService plantmoodService;

    public PlantmoodController(){
        this.plantmoodService = new PlantmoodService();
    }

    @PostMapping
    public void addPlantMood(@RequestBody IPlantmood plantMood){
        plantmoodService.addPlantmood(plantMood);
    }

/*    @GetMapping
    public List<IPlantmood> getAllPlantMood(){
        List<IPlantmood> plantMoods = plantmoodService.getAllPlantmoods();
        return plantMoods;
    }

    @GetMapping(path = {"id"})
    public IPlantmood getPlantMoodById(@PathVariable("id") int id){
        IPlantmood plantMood = plantmoodService.getPlantmoodById(id);
        return plantMood;
    }*/

    @PutMapping
    public void updatePlantMood(IPlantmood plantMood){
        plantmoodService.updatePlantmood(plantMood);
    }

    @DeleteMapping
    public void deletePlantMood(int id){
        plantmoodService.deletePlantmood(id);
    }



}
