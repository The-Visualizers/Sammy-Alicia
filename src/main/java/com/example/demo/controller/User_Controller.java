package com.example.demo.controller;
import java.util.Date;

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
    private User_Repository UserRepository;
    @GetMapping("/all")
    public java.util.List<User> getAllUsers() {
        return UserRepository.findAll();
    }
    @PostMapping("/register")
    public String createNewUser(@RequestBody User newUser){
        
        User user = UserRepository.save(newUser); // in user
        Date date = new Date();
        Cart cart = user.new Cart(date, user.getId_user());
        cartRepository.save(cart);
        return "New User Created with Cart!";
        //pass the user id to return "New User Created with Cart!";e creation function
    }
    @PatchMapping("/name/{id}")
    public String updateUserName(@PathVariable Integer id, @RequestBody String newName) {
    return userService.updateUserName(id, newName);
    }
    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

}
