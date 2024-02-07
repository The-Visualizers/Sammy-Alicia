package com.example.demo.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductTable;
// import com.example.demo.model.User.Cart;

public interface Product_Repository extends JpaRepository<ProductTable, Long>{

    //  @Query("SELECT p FROM ProductTable p WHERE (:id is null OR p.id = :id) AND p.name LIKE %:query%")
    // List<ProductTable> searchProducts(@Param("id") Optional<Integer> Id, @RequestParam("query") String query);

    List<ProductTable> findByName(String name);

    // Optional<ProductTable> findById(Long id_product);

    // Optional<Cart> findAllById( int id_product);
    
}
