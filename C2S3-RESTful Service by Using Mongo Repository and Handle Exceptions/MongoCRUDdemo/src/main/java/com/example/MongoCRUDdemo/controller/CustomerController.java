package com.example.MongoCRUDdemo.controller;

import com.example.MongoCRUDdemo.domain.Customer;
import com.example.MongoCRUDdemo.exception.CustomerAlreadyExistsException;
import com.example.MongoCRUDdemo.exception.CustomerNotFoundException;
import com.example.MongoCRUDdemo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //http://localhost:8081/api/customer/v1/addCust
    @PostMapping("/addCust")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException{
        try {
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
        }
        catch (CustomerAlreadyExistsException customerAlreadyExistsException)
        {
            throw customerAlreadyExistsException;
        }
    }

    //http://localhost:8081/api/customer/v1/getCusts
    @GetMapping("/getCusts")
    public ResponseEntity<?> getAllCustomers()
    {
        return new ResponseEntity<>(customerService.getCustomer(), HttpStatus.OK);
    }

    //http://localhost:8081/api/customer/v1/delCust/XXX
    @DeleteMapping("/delCust/{cid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String cid)throws CustomerNotFoundException
    {
        return new ResponseEntity<>(customerService.deleteCustomer(cid),HttpStatus.OK);
    }

    //http://localhost:8081/api/customer/v1/upCust
    @PutMapping("/upCust")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer)throws CustomerNotFoundException
    {
        return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);
    }



    //http://localhost:8081/api/customer/v1/getOneCust/XXX
    @GetMapping("/getOneCust/{cid}")
    public ResponseEntity<?> getOneCustomer(@PathVariable String cid)
    {
        return new ResponseEntity<>(customerService.getCustomerById(cid),HttpStatus.OK);
    }


    //http://localhost:8081/api/customer/v1/getCustByCity/XXX
    @GetMapping("/getCustByCity/{ct}")
    public ResponseEntity<?> getCustomerbyCity(@PathVariable String ct) {
        return new ResponseEntity<>(customerService.getCustomerByCity(ct),HttpStatus.OK);
    }
}
