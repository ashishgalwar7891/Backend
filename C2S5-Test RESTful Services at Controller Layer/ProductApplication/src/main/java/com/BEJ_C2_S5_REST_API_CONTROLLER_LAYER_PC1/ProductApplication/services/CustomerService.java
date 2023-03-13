package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.services;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;
    public boolean deleteCustomer(String customerId) throws CustomerNotFoundException;
    public List<Customer> getCustomer();
    public List<Customer> getProductByProductName(String pn);

}
