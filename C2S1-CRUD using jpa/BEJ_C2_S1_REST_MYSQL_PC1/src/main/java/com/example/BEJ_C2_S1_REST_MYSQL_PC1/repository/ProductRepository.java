package com.example.BEJ_C2_S1_REST_MYSQL_PC1.repository;

import com.example.BEJ_C2_S1_REST_MYSQL_PC1.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByproductId(String productId);
}
