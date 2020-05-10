package pm.controllers;

import com.oopa.domain.services.PlantSpeciesService;
import com.oopa.interfaces.model.IPlantSpecies;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/plantspecies")
@RestController
public class PlantspeciesController {

    private PlantSpeciesService plantspeciesService;

    public PlantspeciesController(){
        this.plantspeciesService = new PlantSpeciesService();
    }

    @PostMapping
    public void addPlantSpecies(@RequestBody IPlantSpecies plantSpecies){
        plantspeciesService.addPlantSpecies(plantSpecies);
    }

    @GetMapping
    public List<IPlantSpecies> getAllPlantSpecies(){
        List<IPlantSpecies> plantSpecies = plantspeciesService.getAllPlantSpecies();
        return plantSpecies;
    }

    @GetMapping(path = {"id"})
    public Optional<IPlantSpecies> getPlantSpeciesById(@PathVariable("id") int id){
        Optional<IPlantSpecies> plantspecies = plantspeciesService.getPlantSpeciesById(id);
        return plantspecies;
    }

    @DeleteMapping
    public void deletePlantSpecies(@PathVariable int id){
        plantspeciesService.deletePlantSpecies(id);
    }
}
