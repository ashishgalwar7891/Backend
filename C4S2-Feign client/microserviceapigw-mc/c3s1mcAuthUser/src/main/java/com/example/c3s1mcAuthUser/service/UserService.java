package com.example.c3s1mcAuthUser.service;

import com.example.c3s1mcAuthUser.domain.SignUpData;
import com.example.c3s1mcAuthUser.domain.User;
import com.example.c3s1mcAuthUser.exception.UserAlredyExistException;
import com.example.c3s1mcAuthUser.exception.UserNotFoundException;

import java.security.Signature;

public interface UserService {
    public User register(SignUpData signUpData)throws UserAlredyExistException;
    public User registerUsers(User user)throws UserAlredyExistException;
    public User logInUser(User user) throws UserNotFoundException;
}
