package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;
    private UserRepository UserRepository;
    @GetMapping("/all")
    public java.util.List<User> getAllUsers() {
        return UserRepository.findAll();
        
    }
    @PostMapping("/newuser")
    public String createNewUser(@RequestBody User newUser){
        UserRepository.save(newUser);
        return "New User Created!";
    }
    @PatchMapping("/name/{id}")
    public String updateUserName(@PathVariable Long id, @RequestBody String newName) {
    return userService.updateUserName(id, newName);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
