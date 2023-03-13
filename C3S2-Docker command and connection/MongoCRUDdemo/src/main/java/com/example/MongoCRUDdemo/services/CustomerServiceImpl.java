package com.example.MongoCRUDdemo.services;

import com.example.MongoCRUDdemo.domain.Customer;
import com.example.MongoCRUDdemo.exception.CustomerAlreadyExistsException;
import com.example.MongoCRUDdemo.exception.CustomerNotFoundException;
import com.example.MongoCRUDdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if(customerRepository.findById(customer.getCustomerId()).isEmpty()){
            return customerRepository.insert(customer);
        }
        else {
            throw new CustomerAlreadyExistsException();
        }
    }
    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        if(customerRepository.findById(customer.getCustomerId()).isPresent())
        {
            return customerRepository.save(customer);
        }
        else
        {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public boolean deleteCustomer(String customerid) throws CustomerNotFoundException {
        if(customerRepository.findById(customerid).isPresent() )
        {
            customerRepository.deleteById(customerid);
            return true;
        }
        else
        {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public Customer getCustomerById(String customerid) {
        return  customerRepository.findById(customerid).get();
    }

    @Override
    public List<Customer> getCustomerByCity(String ct) {
        return customerRepository.getCustomerByCity(ct);
    }
}
