package com.example.Trusttalk.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Trusttalk.model.User;
import com.example.Trusttalk.repository.UserRepository;
@Service
public class UserService {
       @Autowired
    private UserRepository userRepository;

    // 1. Register New User
    public User registerUser(User userRequest) {

        // Check if email is already used
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        // Check for required fields
        if (userRequest.getUsername() == null || userRequest.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username is required");
        }

        if (userRequest.getPassword() == null || userRequest.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (userRequest.getEmail() == null || userRequest.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        // Set defaults
        userRequest.setStatus("ACTIVE");
        userRequest.setCreatedAt(LocalDate.now());

        // Save to DB
        return userRepository.save(userRequest);
    }

    // 2. Get user by ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // 3. Update User Status
    public void updateUserStatus(String id, String newStatus) {
        Optional<User> userOpt = userRepository.findById(id);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userOpt.get();
        user.setStatus(newStatus);
        userRepository.save(user);
    }

    // 4. Delete user
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
    
}
