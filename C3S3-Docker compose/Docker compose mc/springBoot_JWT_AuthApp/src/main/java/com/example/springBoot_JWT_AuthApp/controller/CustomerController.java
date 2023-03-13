package com.example.springBoot_JWT_AuthApp.controller;


import com.example.springBoot_JWT_AuthApp.domain.Customer;
import com.example.springBoot_JWT_AuthApp.services.CustomerServices;
import com.example.springBoot_JWT_AuthApp.services.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;



    // http://localhost:4444/customer/register  [post]
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer1(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerServices.registerCustomer(customer), HttpStatus.OK);
    }

    // http://localhost:4444/customer/login  [post]
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Customer customer)
    {
        if(customerServices.findByEmailAndPassword(customer)!=null){
            return new ResponseEntity<>(securityTokenGenerator.generateToken(customer),HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Customer Not Found",HttpStatus.EXPECTATION_FAILED);
        }
    }
}
