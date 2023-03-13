package com.example.userauthapp.service;

import com.example.userauthapp.domain.User;

public interface UserService {
    public User createUser(User user);
    public User loginUser(User user);
}
