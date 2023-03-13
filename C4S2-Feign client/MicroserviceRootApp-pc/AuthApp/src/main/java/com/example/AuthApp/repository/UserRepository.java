package com.example.AuthApp.repository;

import com.example.AuthApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{
    //save() ----- Register User
    // findAll()/findById()

    //  findById(email) ---- Login
    // then check pwd

    User findByEmailAndPassword(String email,String password);
    //select * from User where email=** and password=**   --> 1 user data or null

}
