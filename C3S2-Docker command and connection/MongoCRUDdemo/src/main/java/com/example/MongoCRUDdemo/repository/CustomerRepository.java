package com.example.MongoCRUDdemo.repository;

import com.example.MongoCRUDdemo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    //Customer save(Customer c)
    // Customer insert(Customer c)
    //boolean deleteById(String customerId)
    //List<Customer> findAll()
    // Customer findById(String customer)

    // Customer method getting customer by city
    @Query("{'address.city':{$in:[?0]}}")
    public List<Customer> getCustomerByCity(String ct);

}