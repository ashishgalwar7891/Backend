package com.example.AuthApp.service;

import com.example.AuthApp.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator
{
    public Map<String,String> generateToken(User user);
}


// Token : adsfafafsdfsadfsfsdf.asdfdsfsfdgtrsnhbfvbdf.fvbnmtyujkvbn
// message : "login success"