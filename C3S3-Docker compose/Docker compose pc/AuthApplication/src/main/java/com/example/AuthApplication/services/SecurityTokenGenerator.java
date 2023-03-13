package com.example.AuthApplication.services;

import com.example.AuthApplication.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
