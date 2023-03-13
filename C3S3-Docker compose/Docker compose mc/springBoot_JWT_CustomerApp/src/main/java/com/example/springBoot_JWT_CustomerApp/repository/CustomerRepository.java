package com.example.springBoot_JWT_CustomerApp.repository;

import com.example.springBoot_JWT_CustomerApp.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
