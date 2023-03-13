package com.example.BEJ_C1_S5_REST_API_MC1.controller;

import com.example.BEJ_C1_S5_REST_API_MC1.domain.Product;
import com.example.BEJ_C1_S5_REST_API_MC1.servicer.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductServices productServices;

    //http://localhost:9000/api/product/saveprod   [post]  json
    @PostMapping("/saveprod")
    public ResponseEntity<?> save(@RequestBody Product product)
    {
        return new ResponseEntity<>(productServices.save(product), HttpStatus.CREATED);
    }

    //http://localhost:6300/api/product/getprod  [get]
    @GetMapping("/getprod")
    public ResponseEntity<?> getBooks()
    {
        return new ResponseEntity<>(productServices.findAll(),HttpStatus.OK);
    }
}
