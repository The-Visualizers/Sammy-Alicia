package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.User_Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServices {
private final User_Repository userRepository;

public String updateUserName(Long id, String newName) {
    Optional<User> userOptional = userRepository.findById(id);
    if (userOptional.isPresent()) {
        User user = userOptional.get();
        user.setName(newName);
        userRepository.save(user);
        return "User's name updated successfully!";
    } else {
        return "User not found with ID: " + id;
    }
}
public String deleteUser(Long id) {
    try {
        Optional<User> userOptional = userRepository.findById(id);
        
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return "User with ID " + id + " has been successfully deleted.";
        } else {
            return "User with ID " + id + " does not exist.";
        }
    } catch (Exception e) {
        return "An error occurred while trying to delete the user with ID " + id + ": " + e.getMessage();
    }
}
}
