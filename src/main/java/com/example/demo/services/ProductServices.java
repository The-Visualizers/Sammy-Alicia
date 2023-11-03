// package com.example.demo.services;

// import java.util.List;

// import com.example.demo.model.ProductCatalog;
// import com.example.demo.repository.ProductCatalogRepository;

// public class ProductServices {
// private final ProductCatalogRepository productRepository;

//     public ProductServices( ProductCatalogRepository productRepository) {
//         this.productRepository = productRepository;
// }

//     public List<ProductCatalog> searchProducts(String query) {
//         return productRepository.searchProducts(query);
//     }

//     public ProductCatalog createProduct(ProductCatalog product){
//         return productRepository.save(product);
//     }

//     public boolean deleteProduct(Long id){
//         try {
//             productRepository.deleteById(id);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
        
//     }
// }