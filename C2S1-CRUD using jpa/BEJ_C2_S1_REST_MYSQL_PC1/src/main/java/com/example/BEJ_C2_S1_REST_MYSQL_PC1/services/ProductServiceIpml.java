package com.example.BEJ_C2_S1_REST_MYSQL_PC1.services;

import com.example.BEJ_C2_S1_REST_MYSQL_PC1.domain.Product;
import com.example.BEJ_C2_S1_REST_MYSQL_PC1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIpml implements ProductService{
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceIpml(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public List<Product> getProductByProductId(String productId){
     return productRepository.findByproductId(productId);
    }

    @Override
    public boolean deleteProductByProductId(String productId) {
        productRepository.deleteById(productId);
        return true;
    }
}
