package com.example.BabyStore.service;

import com.example.BabyStore.entity.User;
import com.example.BabyStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getByUsername(String username){
        return userRepository.findById(username).get();
    }

    public Boolean existsById(String username){
        return userRepository.existsById(username);
    }
}
