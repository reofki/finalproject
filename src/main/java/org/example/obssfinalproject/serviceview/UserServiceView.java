package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.userDto.UserLoginDto;
import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.dto.userDto.UserRegisterDto;
import org.example.obssfinalproject.dto.userDto.UserUpdateDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface UserServiceView {

    List<UserReadDto> getAllUsers();
    Optional<UserReadDto> getUserById(Long id);
    UserReadDto createUser(UserRegisterDto userRegisterDto);
    ResponseEntity<UserReadDto> updateUser(Long id, UserUpdateDto userUpdateDto);
    ResponseEntity<Void> deleteUser(Long id);

    boolean authenticateUser(UserLoginDto userLoginDto);

    ResponseEntity<UserReadDto> addToBlacklist(Long id, Long blockedUserId);

    ResponseEntity<UserReadDto> addToFavoriteList(Long id, Long favoriteProductId);

    ResponseEntity<UserReadDto> removeFromFavorites(Long id, Long favoriteProductId);

    ResponseEntity<UserReadDto> removeFromBlacklist(Long id, Long blockedUserId);

    ResponseEntity<Boolean> isFavorite(Long id, Long productId);

    ResponseEntity<Boolean> isBlocked(Long id, Long blockedUserId);
}
