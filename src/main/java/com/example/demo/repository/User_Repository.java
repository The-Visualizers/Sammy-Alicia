package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface User_Repository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long id);

    void delete(User user);
    
}
