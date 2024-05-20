package com.login.java.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public String authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "Authentication successful";
        }
        return "Authentication failed";
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return "User updated successfully";
        }
        return "User not found";
    }

    public String deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }

    public String createUser(User user) {
        userRepository.save(user);
        return "User created successfully";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
