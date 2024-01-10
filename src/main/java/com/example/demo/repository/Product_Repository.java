package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ProductTable;

public interface Product_Repository extends JpaRepository<ProductTable, Long>{

     @Query("SELECT p FROM ProductTable p WHERE (:id is null OR p.id = :id) AND p.name LIKE %:query%")
    List<ProductTable> searchProducts(@Param("id") Optional<Long> id, @RequestParam("query") String query);

    List<ProductTable> findByName(String name);

    Optional<ProductTable> findById(Long id);
    
}
