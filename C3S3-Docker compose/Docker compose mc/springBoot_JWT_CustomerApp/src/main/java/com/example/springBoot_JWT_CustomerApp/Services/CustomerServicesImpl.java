package com.example.springBoot_JWT_CustomerApp.Services;

import com.example.springBoot_JWT_CustomerApp.domain.Customer;
import com.example.springBoot_JWT_CustomerApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServicesImpl implements CustomerServices{
    @Autowired
    public CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addUser(Customer customer) {
        return customerRepository.insert(customer);
    }

    @Override
    public boolean deleteById(String id) {
        customerRepository.deleteById(id);
        return true;
    }

}
