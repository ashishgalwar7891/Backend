package com.example.springBoot_JWT_AuthApp.services;


import com.example.springBoot_JWT_AuthApp.domain.Customer;

import java.util.Map;

public interface CustomerServices {
    Customer registerCustomer(Customer customer);
    Customer findByEmailAndPassword(Customer customer);
}
