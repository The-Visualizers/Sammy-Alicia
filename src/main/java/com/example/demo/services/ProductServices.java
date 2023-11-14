package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.ProductTable;
import com.example.demo.repository.Product_Repository;

@Service
public class ProductServices {
    private final Product_Repository productRepository;

    public ProductServices(Product_Repository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductTable> searchProducts(Optional<Long> id, String query) {
        return productRepository.searchProducts(id, query);
    }

    public Object findproductByIdOrNameContaining(String query, Long id) {
        List<ProductTable> products = new ArrayList<>();
        String searchField;
        String value = query; // Initialize value with the query parameter

        // Determine the search field based on the query parameter
        if (query.matches("^\\d+$")) {
            // If the query consists of digits, consider it as an ID search
            searchField = "id";
        } else {
            // Otherwise, consider it as a name search
            searchField = "name";
        }

        if ("name".equalsIgnoreCase(searchField)) {
            products = productRepository.findByName(value);
        } else if ("id".equalsIgnoreCase(searchField)) {
            try {
                ProductTable product = productRepository.findById(id).orElse(null);
                if (product != null) {
                    products.add(product);
                }
            } catch (NumberFormatException e) {
                    return "Please provide a Valid Id"; 
            }
        } else {
            // Handle unknown search field
        }

        return products;
    }

    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public ProductTable createProduct(ProductTable product) {
        return productRepository.save(product);
    }

    public ProductTable updateProduct(ProductTable existingProduct) {
        return null;
    }

    public ProductTable getProductById(Long id) {
        return null;
    }
}