package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Book;
import org.example.obssfinalproject.model.products.Product;


import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();

    void deleteAllProducts();

    List<Product> searchProducts(String keyword);

    void updateScore(Long id, double score);

    Product createProduct(Product product, Long userId);

    List<Product> getFilteredProducts(Long userId);
}
