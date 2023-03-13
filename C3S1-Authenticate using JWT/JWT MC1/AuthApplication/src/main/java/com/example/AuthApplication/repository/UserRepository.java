package com.example.AuthApplication.repository;

import com.example.AuthApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    //save() --->Register user
    //findAll()/findById()

    //findById(email) ---->Login
    //then check password

//    findByEmailAndPassword(String email,String password);
    //select * from User where email=** and password=**   --> 1 user data or null
}
