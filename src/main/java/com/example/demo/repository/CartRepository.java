package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User.Cart;

@Repository
@Component
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // to fetch the cart of a user and order them 
    // list by created the date of each entry in the cart.
    // List<Cart> findAllByuserIdOrderByCreatedDateDesc(Integer userId, Date CreatedDate);

}
