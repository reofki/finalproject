package org.example.obssfinalproject.dto.userDto;

import lombok.Data;
import org.example.obssfinalproject.model.Role;
import org.example.obssfinalproject.model.User;

import java.util.List;
import java.util.Set;

@Data
public class UserReadDto {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private Set<Role> roles;
    private List<Long> favoriteList;
    private List<Long> blackList;
    private double balance;
}
