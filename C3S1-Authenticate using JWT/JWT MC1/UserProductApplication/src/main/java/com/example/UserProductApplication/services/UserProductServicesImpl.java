package com.example.UserProductApplication.services;

import com.example.UserProductApplication.domain.User;
import com.example.UserProductApplication.repository.UserProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProductServicesImpl implements UserProductServices {
    @Autowired
    private UserProductRepository userProductRepository;

    @Override
    public User addUser(User user) {
        return userProductRepository.save(user);
    }

    @Override
    public boolean deleteById(String id) {
        userProductRepository.deleteById(id);
        return true;
    }
}
