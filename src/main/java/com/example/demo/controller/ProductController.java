// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.ProductCatalog;
// import com.example.demo.services.ProductServices;

// @RestController
// public class ProductController {

//     private final ProductServices productService;

//     public ProductController(ProductServices productService) {
//         this.productService = productService;
//     }

//     @GetMapping("/search")
//     public ResponseEntity<List<ProductCatalog>> searchProducts(@RequestParam("query") String query) {
//         return ResponseEntity.ok(productService.searchProducts(query));
//     }

//     @PostMapping("/newproduct")
//     public ProductCatalog createProduct(@RequestBody ProductCatalog product) {
//         return productService.createProduct(product);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//         boolean deleted = productService.deleteProduct(id);
//         if (deleted) {
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }