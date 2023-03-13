package com.example.BEJ_C2_S1_REST_MYSQL_PC1.services;

import com.example.BEJ_C2_S1_REST_MYSQL_PC1.domain.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    List<Product> getProductByProductId(String productId);
    boolean deleteProductByProductId(String productId);
}
