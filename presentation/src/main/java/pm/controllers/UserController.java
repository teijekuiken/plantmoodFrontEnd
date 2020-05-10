package pm.controllers;

import com.oopa.domain.services.UserService;
import com.oopa.interfaces.model.IUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(){
        this.userService = new UserService();
    }

   @PostMapping
    public void addUser(@RequestBody IUser user){
        userService.addUser(user);
    }

    @GetMapping
    public List<IUser> getAllUsers(){
        List<IUser> users = userService.getAllUsers();
        return users;
    }

    @GetMapping(path = {"id"})
    public Optional<IUser> getPersonById(@PathVariable("id") int id){
        Optional<IUser> user =  userService.getUserById(id);
        return user;
    }

    @DeleteMapping
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
