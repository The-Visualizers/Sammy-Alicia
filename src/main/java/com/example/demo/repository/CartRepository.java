package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// import com.example.demo.model.ProductTable;
import com.example.demo.model.User.Cart;
@Repository
@Component
public interface CartRepository extends JpaRepository<Cart, Integer> {

//     List<Cart> findAllItemsInTheCart(ProductTable productTable);
}
