package com.example.c3s1mcAuthUser.service;

import com.example.c3s1mcAuthUser.domain.User;

import java.util.Map;

public interface SecurityTokengenerator {
    public Map<String,String> generateToken(User user);
}
