package com.wyrzel.biblioteka.service.User;

import com.wyrzel.biblioteka.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    void save(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User findByEmail(String email);

    boolean isEmailUnique(String email);

}
