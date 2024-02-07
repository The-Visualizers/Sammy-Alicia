// package com.example.demo.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.services.CartService;
// import com.example.demo.services.ProductServices;

// import lombok.AllArgsConstructor;
// @AllArgsConstructor
// @RestController
// @RequestMapping ("CartItems")
// public class CartItems_Controller{

//     @GetMapping("/search")
//     //You need status report of a 200 here for automation
//     public ResponseEntity<Object> searchCartItems(@RequestParam("query") String query, @RequestParam("id") Integer id_cartItems) {
//         return ResponseEntity.ok(ProductServices.findCartItems(query, id_cartItems));
//     }
//     @PostMapping("/additems")
//     public CartItems createCartItems(@RequestBody CartItems cartItems) {
//         return CartService.addtoCartItems(Integer id_product, String nameofProduct);
//     }

// }