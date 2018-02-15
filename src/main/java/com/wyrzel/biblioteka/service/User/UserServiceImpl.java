package com.wyrzel.biblioteka.service.User;

import com.wyrzel.biblioteka.model.User;
import com.wyrzel.biblioteka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email);

        if(user==null){
            throw new UsernameNotFoundException("User not found: " +email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        if(user.getRole()==User.Role.ADMIN){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else if(user.getRole()==User.Role.USER){
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }


        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }


    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        List<User> AllUsers = new ArrayList<>();
        userRepository.findAll().forEach(AllUsers::add);
        return AllUsers;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
