package com.example.UserProductApplication.repository;


import com.example.UserProductApplication.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProductRepository extends MongoRepository<User,String> {
}
