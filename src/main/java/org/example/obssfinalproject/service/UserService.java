package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    Optional<User> updateUser(Long id, User userDetails);
    ResponseEntity<Void> deleteUser(Long id);

    Optional<User> addToBlacklist(Long id, Long blockedUserId);

    Optional<User> addToFavoriteList(Long id, Long favoriteProductId);

    Optional<User> addToRecommendedProduct(Long id, Long productId);

    Optional<User> followUser(Long id, Long followedUserId);
}
