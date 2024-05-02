package com.bankapp.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankapp.bankapp.model.User;
import com.bankapp.bankapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Hash the password before saving it
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user in the database
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Verify the password
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null; // User not found or invalid password
    }
    
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
