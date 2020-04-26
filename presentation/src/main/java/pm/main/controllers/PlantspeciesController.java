package pm.main.controllers;

import com.oopa.interfaces.model.IPlantSpecies;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.PlantSpecies;

import java.util.List;

@RequestMapping("api/v1/plantspecies")
@RestController
public class PlantspeciesController {

    public PlantspeciesController(){

    }

    @PostMapping
    public void addPlantSpecies(@RequestBody PlantSpecies plantSpecies){

    }

    @GetMapping
    public List<IPlantSpecies> getAllPlantSpecies(){
        return null;
    }

    @GetMapping(path = {"id"})
    public IPlantSpecies getPlantSpeciesById(@PathVariable("id") int id){
        return null;
    }

    @DeleteMapping
    public void deletePlantSpecies(int id){

    }
}
