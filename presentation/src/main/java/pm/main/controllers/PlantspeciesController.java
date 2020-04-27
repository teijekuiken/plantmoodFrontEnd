package pm.main.controllers;

import com.oopa.interfaces.model.IPlantSpecies;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.PlantSpecies;

import java.util.List;

@RequestMapping("api/v1/plantspecies")
@RestController
public class PlantspeciesController {

    private PlantspiecesService plantspiecesService;

    public PlantspeciesController(){
        this.plantspiecesService = new PlantspiecesService();
    }

    @PostMapping
    public void addPlantSpecies(@RequestBody IPlantSpecies plantSpecies){
        plantSpecies.addPlantSpieces(plantSpecies);
    }

    @GetMapping
    public List<IPlantSpecies> getAllPlantSpecies(){
        List<IPlantSpecies> plantSpecies = plantspiecesService.getAllPlantSpecies();
        return plantSpecies;
    }

    @GetMapping(path = {"id"})
    public IPlantSpecies getPlantSpeciesById(@PathVariable("id") int id){
        IPlantSpecies plantspecies = plantspiecesService.getPlantSpeciesById(id);
        return plantspecies;
    }

    @DeleteMapping
    public void deletePlantSpecies(@PathVariable int id){
        plantspiecesService.deletePlantSpecies(id);
    }
}
