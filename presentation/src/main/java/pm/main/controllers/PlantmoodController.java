package pm.main.controllers;

import com.oopa.interfaces.model.IPlantMood;
import com.oopa.interfaces.model.IUser;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.User;

import java.nio.file.Path;
import java.util.List;

@RequestMapping("api/v1/plantmood")
@RestController
public class PlantmoodController {

    public PlantmoodController(){

    }

    @PostMapping
    public void addPlantMood(IPlantMood plantMood){

    }

    @GetMapping
    public List<IPlantMood> getAllPlantMood(){
        return null;
    }

    @GetMapping(path = {"id"})
    public IPlantMood getPlantMoodById(@PathVariable("id") int id){
        return null;
    }

    @PutMapping
    public void updatePlantMood(IPlantMood plantMood){

    }

    @DeleteMapping
    public void deletePlantMood(int id){
         
    }



}
