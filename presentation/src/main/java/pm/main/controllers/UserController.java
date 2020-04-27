package pm.main.controllers;

import com.oopa.interfaces.model.IUser;
import org.springframework.web.bind.annotation.*;
import pm.main.domain.User;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private UserService userService;

    //Hier kunnen we de logica klassen implementeren, bijv UserServices.
    public UserController(){
        this.userService = new UserService();
    }

    @PostMapping
    public void addUser(@RequestBody IUser user){
        userService.addUser(user);
    }

    @GetMapping
    public List<IUser> getAllUsers(){
        List<IUser> users = us.getAllUsers();
        return null;
    }

    @GetMapping(path = {"id"})
    public IUser getPersonById(@PathVariable("id") int id){
        IUser user =  us.getUserById(id);
        return user;
    }

    @DeleteMapping
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
