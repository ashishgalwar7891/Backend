package com.example.userauthapp.service;

import com.example.userauthapp.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String, String> generateToken(User user);
}
