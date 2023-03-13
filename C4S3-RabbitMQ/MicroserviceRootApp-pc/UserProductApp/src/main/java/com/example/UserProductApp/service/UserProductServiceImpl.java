package com.example.UserProductApp.service;

import com.example.UserProductApp.domain.User;
import com.example.UserProductApp.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductServiceImpl implements UserProductService
{
    @Autowired
    private UserProductRepository userProductRepository;

    @Override
    public User addUser(User user) {
        return userProductRepository.insert(user);
    }

    @Override
    public User getAllUser(String email) {
        return userProductRepository.findById(email).get();
    }
}
