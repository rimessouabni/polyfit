package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.User;
import com.polyfit.polyfit.repository.UserRepository;
import com.polyfit.polyfit.services.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/get-user/{id}")
    public User getSingleUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/remove-user/{id}")
    public boolean deleteUser(@PathVariable("id") Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PostMapping("/add-user")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User newUser) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Save the new user to the database
            User savedUser = userRepository.save(newUser);

            // Return success response
            response.put("success", true);
            response.put("user", savedUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return error response if there's any exception
            response.put("success", false);
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User currentUser = userRepository.findById(id).orElse(null);
        if (currentUser != null) {
            // Update user attributes
            currentUser.setUsername(updatedUser.getUsername());
            currentUser.setEmail(updatedUser.getEmail());
            currentUser.setPassword(updatedUser.getPassword());
            currentUser.setDateOfBirth(updatedUser.getDateOfBirth());
            currentUser.setWorkoutType(updatedUser.getWorkoutType());
            currentUser.setFitnessLevel(updatedUser.getFitnessLevel());

            // Save the updated user
            userRepository.save(currentUser);
        }
        return currentUser;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            Map<String, Object> response = new HashMap<>();
            response.put("userId", user.getId());
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("message", "Invalid email or password"));
        }
    }
}
