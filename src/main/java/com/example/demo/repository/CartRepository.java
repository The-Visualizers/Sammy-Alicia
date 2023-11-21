package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // to fetch the cart of a user and order the 
    // list by created the date of each entry in the cart.
    List<Cart> findAllByUserIdOrderByCreatedDateDesc(Integer userId);

}