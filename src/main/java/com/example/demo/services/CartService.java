package com.example.demo.services;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductTable;
import com.example.demo.repository.CartRepository;



@Service
public class CartService {
    CartRepository cartRepository;

    public void updateCartItem(int userId, ProductTable product) {
    
    }

    public void deleteCartItem(int items_id, int Cartid) {
        try {
            cartRepository.deleteById(items_id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Cart id is invalid: " + Cartid);
        }
    }
    

}
// Long createCart(Long userId);
//     Cart getCartById(Long cartId);
//     void addItemToCart(Long cartId, Long productId, int quantity);
//     void removeItemFromCart(Long cartId, Long productId);
//     void updateCartItemQuantity(Long cartItemId, int quantity);
//     List<CartItem> getCartItems(Long cartId);
//     void clearCart(Long cartId);