package com.example.demo.repository;
import java.util.List;

import com.example.demo.model.CartItems;
import com.example.demo.model.User;

public interface CartItemsRepository {
    List<CartItems> getByUser(User user);
}
