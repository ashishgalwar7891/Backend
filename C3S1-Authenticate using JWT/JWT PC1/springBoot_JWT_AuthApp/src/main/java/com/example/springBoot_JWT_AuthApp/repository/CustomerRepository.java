package com.example.springBoot_JWT_AuthApp.repository;

import com.example.springBoot_JWT_AuthApp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
//    public Customer findByEmailAndPassword(String email,String password);
}
