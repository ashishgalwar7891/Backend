package com.example.AuthApplication.services;

import com.example.AuthApplication.domain.User;

public interface UserServices {
     User registerUser(User user);
     User checkLogin(User user);
}
