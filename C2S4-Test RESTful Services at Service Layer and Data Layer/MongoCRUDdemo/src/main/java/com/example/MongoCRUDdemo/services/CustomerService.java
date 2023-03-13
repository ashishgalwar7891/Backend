package com.example.MongoCRUDdemo.services;

import com.example.MongoCRUDdemo.domain.Customer;
import com.example.MongoCRUDdemo.exception.CustomerAlreadyExistsException;
import com.example.MongoCRUDdemo.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;
    public List<Customer> getCustomer();
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    public boolean deleteCustomer(String customerId) throws CustomerNotFoundException;
    public Customer getCustomerById(String customerId);
    public List<Customer> getCustomerByCity(String ct);
}
