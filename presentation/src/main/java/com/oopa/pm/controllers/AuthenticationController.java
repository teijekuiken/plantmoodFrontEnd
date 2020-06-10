package com.oopa.pm.controllers;

import com.oopa.domain.dto.UserLoginInputDTO;
import com.oopa.domain.dto.UserLoginOutputDTO;
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
            throw new Exception("Incorrect user or password");
        }

        final UserDetails userDetails = userService
                .loadUserByUsername(user.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new UserLoginOutputDTO(jwt));
    }
}
