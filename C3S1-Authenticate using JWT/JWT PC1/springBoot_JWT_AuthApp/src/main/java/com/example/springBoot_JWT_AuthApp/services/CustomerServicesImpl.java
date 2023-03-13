package com.example.springBoot_JWT_AuthApp.services;

import com.example.springBoot_JWT_AuthApp.domain.Customer;
import com.example.springBoot_JWT_AuthApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServicesImpl implements CustomerServices
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByEmailAndPassword(Customer customer) {
//        return customerRepository.findByEmailAndPassword(customer.getEmail(),customer.getPassword());
        if(customerRepository.findById(customer.getEmail()).isPresent())
        {
            Customer cost=customerRepository.findById(customer.getEmail()).get();
            if(cost.getPassword().equals(customer.getPassword()))
            {
                return cost;
            }
            else
            {
                return null;
            }
        }
        return null;
    }
}

