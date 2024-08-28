package com.TheFirstChatApp.FirstChatApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheFirstChatApp.FirstChatApp.models.User;
import com.TheFirstChatApp.FirstChatApp.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
     public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public void saveUser(User user){
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }
    public boolean userExists(String username){
        Optional<User> existingUser = userRepository.findByUsername(username);
        return existingUser.isPresent();
    }
    public boolean validateUser(String username, String password) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
