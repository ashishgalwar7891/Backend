package com.example.BEJ_C1_S5_REST_API_MC1.servicer;

import com.example.BEJ_C1_S5_REST_API_MC1.domain.Product;

import java.util.List;

public interface ProductServices {
    public Product save(Product product);
    public List<Product> findAll();
}
