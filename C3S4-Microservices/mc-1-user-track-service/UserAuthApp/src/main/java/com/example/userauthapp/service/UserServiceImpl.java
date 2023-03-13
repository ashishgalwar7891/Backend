package com.example.userauthapp.service;

import com.example.userauthapp.domain.User;
import com.example.userauthapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(User user) {
        if (userRepository.findById(user.getUsername()).isPresent()) {
            User userObj = userRepository.findById(user.getUsername()).get();
            if (userObj.getPassword().equals(user.getPassword())) {
                return userObj;
            } else {
                return null;

            }
        }
        return null;
    }
}