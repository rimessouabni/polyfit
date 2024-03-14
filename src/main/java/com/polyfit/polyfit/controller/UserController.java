package com.polyfit.polyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.polyfit.polyfit.model.User;
import com.polyfit.polyfit.repository.UserRepository;
import com.polyfit.polyfit.services.UserService;

import java.util.List;
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

    @PutMapping("/update-user/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User currentUser = userRepository.findById(id).orElse(null);
        if (currentUser != null) {
            // Update user attributes
            currentUser.setUsername(updatedUser.getUsername());
            currentUser.setEmail(updatedUser.getEmail());
            currentUser.setPassword(updatedUser.getPassword());
            currentUser.setDateOfBirth(updatedUser.getDateOfBirth());
            // Save the updated user
            userRepository.save(currentUser);
        }
        return currentUser;
    }

    @PostMapping("/add-user")
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
