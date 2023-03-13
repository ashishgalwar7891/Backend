package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.repository;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    //Customer save(Customer c)
    // Customer insert(Customer c)
    //boolean deleteById(String customerId)
    //List<Customer> findAll()
    // Customer findById(String customer)

    //fetch All the details of customers who having samsung phone
    @Query("{'customerProduct.productName':{$in:[?0]}}")
    public List<Customer> getProductByProductName(String productName);
}
