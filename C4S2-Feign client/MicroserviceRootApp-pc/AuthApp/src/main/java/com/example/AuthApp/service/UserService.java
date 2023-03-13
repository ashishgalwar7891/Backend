package com.example.AuthApp.service;

import com.example.AuthApp.domain.SignUpData;
import com.example.AuthApp.domain.User;

public interface UserService
{
    public User registerUser1(SignUpData signUpData);
    public User registerUser(User user);
    public User checkLogin(User user);
}
