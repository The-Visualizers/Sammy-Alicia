package com.example.demo.services;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductTable;
import com.example.demo.repository.Product_Repository;



@Service
public class CartService {
    Product_Repository productRepository;
   
    public void updateCartItem(int userId, ProductTable product) {
    
    }

    public void deleteCartItem(Long items_id, Long Cartid) {
        try {
            //Here the question becomes the issue where the cart repositiory not needed
            productRepository.deleteById(items_id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Cart id is invalid: " + Cartid);
        }
    }
    

}
