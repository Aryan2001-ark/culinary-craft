package com.aryan.culinary_craft.controller;

import com.aryan.culinary_craft.model.User;
import com.aryan.culinary_craft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userRequest) {
        boolean userExists = userRepository.findByUsername(userRequest.getUsername()).isPresent();
        if (userExists) {
            return ResponseEntity.badRequest().body("Username already exists. Please choose another.");
        }

        boolean shouldEncrypt = true; // You control this
        String finalPassword = shouldEncrypt
                ? passwordEncoder.encode(userRequest.getPassword())
                : userRequest.getPassword();

        User user = User.builder()
                .username(userRequest.getUsername())
                .password(finalPassword)
                .role("USER")
                .isEncrypted(shouldEncrypt)
                .build();

        userRepository.save(user);
        return ResponseEntity.ok("You are successfully registered to our system.");
    }
}
