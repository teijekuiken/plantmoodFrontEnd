package com.oopa.pm.controllers;

import com.oopa.domain.dto.user.UserOutputDTO;
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
    public @ResponseBody User addUser(@RequestBody User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.addUser(user);
    }

    @GetMapping
    public @ResponseBody List<UserOutputDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody UserOutputDTO getPersonById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "User is deleted";
    }
}
