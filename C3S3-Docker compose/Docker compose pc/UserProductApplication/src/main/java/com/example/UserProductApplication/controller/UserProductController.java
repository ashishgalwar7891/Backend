package com.example.UserProductApplication.controller;

import com.example.UserProductApplication.domain.User;
import com.example.UserProductApplication.repository.UserProductRepository;
import com.example.UserProductApplication.services.UserProductServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class UserProductController {
    @Autowired
    private UserProductServices userProductServices;
    @Autowired
    private UserProductRepository userProductRepository;

    // http://localhost:555/product/getUser   [get]
    @GetMapping("/getUser")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(userProductRepository.findAll(),HttpStatus.OK);
    }

    // http://localhost:555/product/addUser  [Post]
    @PostMapping("/addUser")
    public ResponseEntity<?> addUserProduct(@RequestBody User user)
    {
        return new ResponseEntity<>(userProductServices.addUser(user), HttpStatus.OK);
    }

    // http://localhost:555/product/delete/*  [delete]
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        return new ResponseEntity<>(userProductServices.deleteById(id),HttpStatus.OK);
    }
}
