package pm.main.controllers;

import com.oopa.interfaces.model.IUser;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.User;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    //Hier kunnen we de logica klassen implementeren, bijv UserServices.
    public UserController(){

    }

    @PostMapping
    public void addUser(@RequestBody User user){

    }

    @GetMapping
    public List<IUser> getAllUSer(){
        return null;
    }

    @GetMapping(path = {"id"})
    public User getPersonById(@PathVariable("id") int id){
        return null;
    }

    @DeleteMapping
    public void deleteUser(){

    }

}
