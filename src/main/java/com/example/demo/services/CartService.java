package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductTable;
import com.example.demo.repository.Product_Repository;

@Service
public class CartService {

    // private static final Integer Interger = null;

    @Autowired
    private Product_Repository productRepository;

    // @Autowired
    // private CartRepository cartRepository;

    // public void addtoCartItems(int id_product, Integer userId) {
    //     // Assuming ProductTable is the entity representing a product in your database
    //     ProductTable product = productRepository.findById(id_product).orElse(null);

    //     if (product != null) {
    //         // Find the cart by user ID or create a new one if not found
    //         // Cart cart = userId.(product);

    //         // Add the product to the cart
    //         cart.addProduct(product);

    //         // Print the items in the cart (for demonstration purposes)
    //         System.out.println("Items in the cart:");
    //         cart.getProducts().forEach(p -> System.out.println(p.getName()));

    //         // Save the updated cart to the database
    //         cartRepository.save(cart);

    //         // For example, you could print a message for demonstration purposes
    //         System.out.println("Added item to cart: " + product.getName());

    //         // You can also choose to update the product status or quantity, etc.
    //         // based on your specific requirements
    //     } else {
    //         System.out.println("Product not found with id: " + id_product);
    //         // Handle the case where the product with the given id is not found
    //     }
    // }



    public void updateCartItem(int userId, ProductTable product) {

    }

    public void deleteCartItem(Long items_id, Long Cartid) {
        try {
            // Here the question becomes the issue where the cart repositiory not needed
            productRepository.deleteById(items_id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Cart id is invalid: " + Cartid);
        }
    }

}