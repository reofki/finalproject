package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.model.products.Book;
import org.example.obssfinalproject.model.products.Product;
import org.example.obssfinalproject.repository.ProductRepository;
import org.example.obssfinalproject.repository.UserRepository;
import org.example.obssfinalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByTitleContainingOrExplanationContainingIgnoreCase(keyword,keyword);
    }


    @Override
    public void updateScore(Long id, double score) {
        productRepository.findById(id).ifPresent(product -> {
            product.setScore(score);
            productRepository.save(product);
        });
    }

    @Override
    public Product createProduct(Product product, Long userId) {
        product.setUserId(userId);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getFilteredProducts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        List<Long> blacklistedUserIds = user.getBlackList();
        return productRepository.findAllByUserIdNotIn(blacklistedUserIds);
    }
}
