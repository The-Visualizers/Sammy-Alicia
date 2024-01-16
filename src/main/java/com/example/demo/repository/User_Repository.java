package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface User_Repository extends JpaRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findById(Integer id);

    void delete(User user);
    
}
