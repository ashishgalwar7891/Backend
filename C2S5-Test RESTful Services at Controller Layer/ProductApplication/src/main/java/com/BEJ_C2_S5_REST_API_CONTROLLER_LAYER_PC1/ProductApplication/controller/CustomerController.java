package com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.controller;

import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerAlreadyExistsException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.Exceptions.CustomerNotFoundException;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.domain.Customer;
import com.BEJ_C2_S5_REST_API_CONTROLLER_LAYER_PC1.ProductApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/v1/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //http://localhost:8888/api/customer/v1/addCustomer
    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        try {
            return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
        }
        catch (CustomerAlreadyExistsException customerAlreadyExistsException)
        {
            throw customerAlreadyExistsException;
        }
    }

    //http://localhost:8888/api/customer/v1/getCustomer
    @GetMapping("/getCustomer")
    public ResponseEntity<?> getAllCustomers()
    {
        return new ResponseEntity<>(customerService.getCustomer(), HttpStatus.OK);
    }

    //http://localhost:8888/api/customer/v1/deleteCustomer/XXX
    @DeleteMapping("/deleteCustomer/{cid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String cid)throws CustomerNotFoundException
    {
        return new ResponseEntity<>(customerService.deleteCustomer(cid),HttpStatus.OK);
    }
    //http://localhost:8888/api/customer/v1/getCustomerBySamsung/XXX
    @GetMapping("/getCustomerBySamsung/{pn}")
    public ResponseEntity<?> getProductByProductName(@PathVariable String pn) {
        return new ResponseEntity<>(customerService.getProductByProductName(pn),HttpStatus.OK);
    }
}
