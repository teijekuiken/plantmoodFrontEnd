package pm.controllers;

import com.oopa.domain.model.User;
import com.oopa.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = {"id"})
    public @ResponseBody User getPersonById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping
    public @ResponseBody User deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

}
