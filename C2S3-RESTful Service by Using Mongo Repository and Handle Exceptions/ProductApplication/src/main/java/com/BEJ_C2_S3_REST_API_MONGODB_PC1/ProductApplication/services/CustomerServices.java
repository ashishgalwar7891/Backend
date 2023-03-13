package com.BEJ_C2_S3_REST_API_MONGODB_PC1.ProductApplication.services;

import com.BEJ_C2_S3_REST_API_MONGODB_PC1.ProductApplication.domain.Customer;
import com.BEJ_C2_S3_REST_API_MONGODB_PC1.ProductApplication.exception.CustomerAlreadyExistsException;
import com.BEJ_C2_S3_REST_API_MONGODB_PC1.ProductApplication.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerServices {
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;
    public boolean deleteCustomer(String customerId) throws CustomerNotFoundException;
    public List<Customer> getCustomer();
    public List<Customer> getProductByProductName(String pn);

}
