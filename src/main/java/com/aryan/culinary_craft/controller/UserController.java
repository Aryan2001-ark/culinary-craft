package com.aryan.culinary_craft.controller;

import com.aryan.culinary_craft.constants.UserConstants;
import com.aryan.culinary_craft.dto.DeleteUserRequest;
import com.aryan.culinary_craft.model.User;
import com.aryan.culinary_craft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/culinary-craft/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User userRequest) {
        logger.info("Received registration request for username: {}", userRequest.getUsername());
        // Username validation: more than 8 characters
        if (userRequest.getUsername() == null || userRequest.getUsername().length() <= 8) {
            logger.warn("Registration failed: Username too short or null");
            return ResponseEntity.badRequest().body("Username must be more than 8 characters.");
        }

        // Password validation: at least 8 chars, 1 lower, 1 upper, 1 special
        String password = userRequest.getPassword();
        if (password == null || password.length() < 8 ||
                !password.matches(".*[a-z].*") ||
                !password.matches(".*[A-Z].*") ||
                !password.matches(".*[^a-zA-Z0-9].*")) {
            logger.warn("Registration failed for username {}: Password policy not met", userRequest.getUsername());
            return ResponseEntity.badRequest().body(
                    "Password must be at least 8 characters long and contain at least 1 lowercase letter, 1 uppercase letter, and 1 special character.");
        }

        boolean userExists = userRepository.findByUsername(userRequest.getUsername()).isPresent();
        if (userExists) {
            logger.warn("Registration failed: Username {} already exists", userRequest.getUsername());
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
        logger.info("User registered successfully: {}", userRequest.getUsername());
        return ResponseEntity.ok("You are successfully registered to our system.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam String usernameToDelete, @RequestParam String requesterUsername) {
        logger.info("Received delete user request for username: {} by requester: {}", usernameToDelete, requesterUsername);
        // Find the requester in the database
        User requester = userRepository.findByUsername(requesterUsername).orElse(null);
        if (requester == null) {
            logger.warn("Delete failed: Requester {} not found", requesterUsername);
            return ResponseEntity.status(403).body("Requester not found.");
        }
        if (!UserConstants.ADMIN.equals(requester.getRole())) {
            logger.warn("Delete failed: Requester {} is not ADMIN", requesterUsername);
            return ResponseEntity.status(403).body("Only ADMIN users can delete users.");
        }
        // Find the user to delete
        User userToDelete = userRepository.findByUsername(usernameToDelete).orElse(null);
        if (userToDelete == null) {
            logger.warn("Delete failed: User {} not found", usernameToDelete);
            return ResponseEntity.badRequest().body("User to delete not found.");
        }
        userRepository.delete(userToDelete);
        logger.info("User {} deleted by ADMIN {}", usernameToDelete, requesterUsername);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
