package com.oopa.domein.services;

import com.oopa.interfaces.model.IUser;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public void addUser(IUser user){
        userRepository.createUser(user.getName(), user.getPassword(), user.getEmail());
    }
    
    public IUser getUserById(int id){
        IUser user = userRepository.getUser(id);
        return user;
    }

    public List<IUser> getAllUsers(){
        List<IUser> allUsers = userRepository.getAllUsers();
        return allUsers;
    }

    public void deleteUser(int id){
        userRepository.deleteUser(id);
    }
}
