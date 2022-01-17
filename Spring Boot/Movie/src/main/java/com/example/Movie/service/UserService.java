package com.example.Movie.service;

import com.example.Movie.entity.User;
import com.example.Movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean existsById(String username) {
        return userRepository.existsById(username);
    }

    public User findUserByUsername(String username) {
        return userRepository.getById(username);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
