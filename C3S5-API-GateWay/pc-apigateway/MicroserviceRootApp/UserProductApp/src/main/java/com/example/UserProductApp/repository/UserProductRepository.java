package com.example.UserProductApp.repository;

import com.example.UserProductApp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProductRepository extends MongoRepository<User,String>
{
    //insert()
    //findAll()
}
