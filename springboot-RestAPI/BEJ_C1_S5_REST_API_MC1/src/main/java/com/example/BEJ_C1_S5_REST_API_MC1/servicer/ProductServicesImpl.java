package com.example.BEJ_C1_S5_REST_API_MC1.servicer;

import com.example.BEJ_C1_S5_REST_API_MC1.domain.Product;
import com.example.BEJ_C1_S5_REST_API_MC1.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServicesImpl implements ProductServices{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product){
        return (Product) productRepository.save(product);
    }
    @Override
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }
}
