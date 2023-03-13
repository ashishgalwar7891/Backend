package com.example.springBoot_JWT_AuthApp.services;

import com.example.springBoot_JWT_AuthApp.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(Customer customer);
}
