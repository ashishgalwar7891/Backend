package com.example.BEJ_C1_S5_REST_API_MC1.reponsitory;

import com.example.BEJ_C1_S5_REST_API_MC1.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product,String>{
    Product save();
    Iterable<Product> findAll();    // retrive all
}
