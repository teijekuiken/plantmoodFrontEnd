package com.oopa.domain.services;

import com.oopa.dataAccess.model.Plantmood;
import com.oopa.dataAccess.repositories.UserRepository;
import com.oopa.domain.dto.user.UserOutputDTO;
import com.oopa.domain.model.User;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlantmoodService plantmoodService;

    public User addUser(User user) throws Exception {
        var userEntity = this.modelMapper.map(user, com.oopa.dataAccess.model.User.class);
        try {
            return this.modelMapper.map(userRepository.save(userEntity), User.class);
        } catch (DataIntegrityViolationException e) {
            if (e.getCause().getClass() == ConstraintViolationException.class) {
                throw new Exception ("Gebruiker met email " + user.getEmail() + " bestaat al");
            }

            throw new Exception("De data is niet juist: " + e.getMessage());
        }
    }
    
    public UserOutputDTO getUserById(Integer id){
        var optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + User.class.getName() + " with id " + id);
        }
        var user = optionalUser.get();
        for (Plantmood plantmood : user.getPlantmoods()) {
            plantmoodService.updateHealthFromHistory(plantmood);
        }

        return this.modelMapper.map(user, UserOutputDTO.class);
    }

    public List<UserOutputDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(user -> this.modelMapper.map(user, UserOutputDTO.class))
                .collect(Collectors.toList());
    }

    public User deleteUser(Integer id){
        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + User.class.getName() + " with id " + id);
        }
        userRepository.deleteById(id);
        return this.modelMapper.map(user.get(), User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + User.class.getName() + " with email " + email);
        }

        var user = optionalUser.get();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }

    public UserOutputDTO getUserByEmail(String email) {
        var optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("Couldn't find " + User.class.getName() + " with email " + email);
        }
        var user = optionalUser.get();
        for (Plantmood plantmood : user.getPlantmoods()) {
            plantmoodService.updateHealthFromHistory(plantmood);
        }
        return this.modelMapper.map(user, UserOutputDTO.class);
    }
}
