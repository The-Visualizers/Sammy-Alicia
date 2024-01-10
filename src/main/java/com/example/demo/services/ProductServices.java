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
    ProductTable products;

    public ProductServices(Product_Repository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductTable> searchProducts(Optional<Long> id, String query) {
        return productRepository.searchProducts(id, query);
    }

    public Object findProductByIdOrName(String query, Long id) {
        //putting products into an empty array
        List<ProductTable> products = new ArrayList<>();
        String searchField = null;
        Object searchValue = null;

        // Determine the search field based on the query parameter
        if (query.matches("^\\d+$")) {
            // If the query consists of digits, consider it as an ID search
            searchField = "id";
            searchValue = id;
        } else {
            // Otherwise, consider it as a name search
            searchField = "name";
            searchValue = query;
        }

        if ("name".equalsIgnoreCase(searchField)) {
            // Search by name
            products = productRepository.findByName((String) searchValue);
        } else if ("id".equalsIgnoreCase(searchField)) {
            try {
                // Search by ID
                Long searchId = Long.parseLong(searchValue.toString());
                ProductTable product = productRepository.findById(searchId).orElse(null);

                if (product != null) {
                    products.add(product);
                } else {
                    // Throw an error message if the product with the given ID is not found
                    throw new IllegalArgumentException("Product with ID " + searchId + " not found");
                }
            } catch (NumberFormatException e) {
                // Throw an error message if the ID is not a valid Long
                throw new IllegalArgumentException("Please provide a valid ID");
            }
        } else {
            // Handle unknown search field
            throw new IllegalArgumentException("Unknown search field: " + searchField);
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
        return products;
    }

}

