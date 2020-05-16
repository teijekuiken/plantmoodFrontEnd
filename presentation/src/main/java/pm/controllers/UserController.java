package pm.controllers;

import com.oopa.domain.model.User;
import com.oopa.domain.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(){
        this.userService = new UserService();
    }

   @PostMapping
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public @ResponseBody List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping(path = {"id"})
    public @ResponseBody User getPersonById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @DeleteMapping
    public @ResponseBody User deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}
