package com.example.BEJ_C2_S1_REST_MYSQL_PC1.controller;

import com.example.BEJ_C2_S1_REST_MYSQL_PC1.domain.Product;
import com.example.BEJ_C2_S1_REST_MYSQL_PC1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity<?> getProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.FOUND);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId){
        return new ResponseEntity<>(productService.getProductByProductId(productId),HttpStatus.FOUND);
    }
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
        return new ResponseEntity<>(productService.deleteProductByProductId(productId),HttpStatus.ACCEPTED);
    }
}
