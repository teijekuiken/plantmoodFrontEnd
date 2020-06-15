package com.oopa.pm.controllers;

import com.oopa.domain.dto.user.CurrentUserInputDTO;
import com.oopa.domain.dto.user.UserLoginInputDTO;
import com.oopa.domain.dto.user.UserLoginOutputDTO;
import com.oopa.domain.dto.user.UserOutputDTO;
import com.oopa.domain.services.UserService;
import com.oopa.domain.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/api/v1/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginInputDTO user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect password");
        }

        final UserDetails userDetails = userService
                .loadUserByUsername(user.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new UserLoginOutputDTO(jwt));
    }

    @PostMapping(value = "/api/v1/currentUser")
    public UserOutputDTO getCurrentUserByToken(@RequestBody CurrentUserInputDTO currentUserInputDTO) {
        var email = jwtUtil.extractUsername(currentUserInputDTO.getJwt());

        return userService.getUserByEmail(email);
    }
}
