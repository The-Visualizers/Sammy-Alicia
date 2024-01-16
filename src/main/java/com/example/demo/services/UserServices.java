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


// creating a new user you are creating a cart with it(crreating a new)
// call an interation for the the cartitems
// calling the cart table 
// pass the userid to the function of the initial cart

public String updateUserName(Integer id, String newName) {
    Optional<User> userOptional = userRepository.findById(id);
    if (userOptional.isPresent()) {
        User user = userOptional.get();
        user.setUsername(newName);
        userRepository.save(user);
        return "User's name updated successfully!";
    } else {
        return "User not found with ID: " + id;
    }
}
public String deleteUser(Integer id) {
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
