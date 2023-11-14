package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductTable;
import com.example.demo.services.ProductServices;
@RestController
public class Product_Controller {

    private final ProductServices productService;

    public Product_Controller(ProductServices productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchProducts(@RequestParam("query") String query, @RequestParam("id") Long id ) {
        return ResponseEntity.ok(productService.findproductByIdOrNameContaining(query, id));
    }

    @PostMapping("/newproduct")
    public ProductTable createProduct(@RequestBody ProductTable product) {
        return productService.createProduct(product);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProductTable> updateProduct(
    @PathVariable Long id,
    @RequestBody ProductTable updatedProduct) {
    ProductTable existingProduct = productService.getProductById(id);

    if (existingProduct == null) {
        return ResponseEntity.notFound().build();
    }
    // Apply the changes from the updatedProduct to the existingProduct
    if (updatedProduct.getName() != null) {
        existingProduct.setName(updatedProduct.getName());
    }
    if (updatedProduct.getPrice() != null) {
        existingProduct.setPrice(updatedProduct.getPrice());
    }
    // Save the updated product
    ProductTable savedProduct = productService.updateProduct(existingProduct);
    return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}