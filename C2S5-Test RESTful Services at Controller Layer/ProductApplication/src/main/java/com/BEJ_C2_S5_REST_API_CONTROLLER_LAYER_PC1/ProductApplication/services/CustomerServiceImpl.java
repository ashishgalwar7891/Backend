package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.services;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Customer;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
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
    public boolean deleteCustomer(String customerId) throws CustomerNotFoundException {
        if(customerRepository.findById(customerId).isPresent() )
        {
            customerRepository.deleteById(customerId);
            return true;
        }
        else
        {
            throw new CustomerNotFoundException();
        }
    }
    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
    @Override
    public List<Customer> getProductByProductName(String pn) {
        return customerRepository.getProductByProductName(pn);
    }
}

