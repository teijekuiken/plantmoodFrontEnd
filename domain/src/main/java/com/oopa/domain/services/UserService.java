package com.oopa.domain.services;

import com.oopa.dataAccess.repositories.UserRepository;
import com.oopa.interfaces.model.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(IUser user){
        userRepository.save(user);
    }
    
    public Optional<IUser> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public List<IUser> getAllUsers(){
        return (List<IUser>) userRepository.findAll();
    }

    public String deleteUser(Integer id){
        Optional<IUser> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return "User with id:" + id + "is deleted";
        } else {
            throw new RuntimeException("User with id: " + id + "not found");
        }
    }
}