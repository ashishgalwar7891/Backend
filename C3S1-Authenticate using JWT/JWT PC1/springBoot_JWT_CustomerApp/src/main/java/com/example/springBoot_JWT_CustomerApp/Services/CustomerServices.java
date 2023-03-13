package com.example.springBoot_JWT_CustomerApp.Services;

import com.example.springBoot_JWT_CustomerApp.domain.Customer;

import java.util.List;

public interface CustomerServices {
    public List<Customer> getAllCustomer();
    public Customer  addUser(Customer customer);
    public boolean deleteById(String id);

}
