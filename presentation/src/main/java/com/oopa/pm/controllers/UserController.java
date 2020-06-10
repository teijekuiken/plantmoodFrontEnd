package com.oopa.pm.controllers;

import com.oopa.domain.model.User;
import com.oopa.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(value = "/create")
    public @ResponseBody User addUser(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.addUser(user);
    }

    @GetMapping
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getPersonById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody User deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
