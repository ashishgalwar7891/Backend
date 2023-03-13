package com.example.springBoot_JWT_CustomerApp.controller;

import com.example.springBoot_JWT_CustomerApp.Services.CustomerServices;
import com.example.springBoot_JWT_CustomerApp.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    //http://localhost:5555/customer/
    @GetMapping("/")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerServices.getAllCustomer(), HttpStatus.OK);
    }
    //http://localhost:5555/customer/addCustomer
    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerServices.addUser(customer), HttpStatus.CREATED);
    }
    //http://localhost:5555/customer/delete/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        return new ResponseEntity<>(customerServices.deleteById(id),HttpStatus.OK);
    }
}
