package com.example.demo.controller;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.User.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.User_Repository;
import com.example.demo.services.UserServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class User_Controller {
    
    private CartRepository cartRepository;
    private UserServices userService;
    private User_Repository userRepository;
    @GetMapping("/all")
    public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/register")
    public String createNewUser(@RequestBody User newUser){
        
        User user = userRepository.save(newUser); // in user
        Date date = new Date();
        Cart cart = user.new Cart(date, user.getId_user());
        cartRepository.save(cart);
        return "New User Created with Cart!";
        //pass the user id to return "New User Created with Cart!";e creation function
    }
    @PatchMapping("/name/{id}")
    public ResponseEntity updateUserName(@PathVariable Integer id, @RequestBody User request) {
        // Get the id from user then i want to adjsut their username 
        //make sure the user exist
        //retrieve the user
        Optional<User> existingUserOptional = userRepository.findById(id);
        User existingUser = new User(); 
        if (existingUserOptional.isPresent()){
            existingUser = existingUserOptional.get();
        }
        //checking the request body for the username field
        if(request.getUsername()!= null){
            //if exists then we set the username to the existing object
            existingUser.setUsername(request.getUsername());
            
        }else{
            //if doesn't then we return a bad request error
            return ResponseEntity.badRequest().build();
        }
        //save the adjusted object 
        return ResponseEntity.ok(userRepository.save(existingUser));

    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
