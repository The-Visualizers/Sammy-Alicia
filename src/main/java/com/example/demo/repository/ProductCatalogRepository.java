package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductCatalog;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
//     @Query
//     ("SELECT p FROM Product p WHERE " +
//     "p.name LIKE CONCAT('%',:query, '%')" +
//     "Or p.description LIKE CONCAT('%', :query, '%')")

// List<ProductCatalog> searchProducts(String query);

}