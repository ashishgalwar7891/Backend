package com.example.AuthApp.service;

import com.example.AuthApp.domain.User;

public interface UserService
{
    public User registerUser(User user);
    public User checkLogin(User user);
}
