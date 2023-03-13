package com.example.UserProductApp.service;

import com.example.UserProductApp.domain.User;

import java.util.List;

public interface UserProductService
{
    public User addUser(User user);
    public User getAllUser(String email);
}
