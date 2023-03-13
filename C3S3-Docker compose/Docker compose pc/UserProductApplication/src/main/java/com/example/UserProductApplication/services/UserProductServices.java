package com.example.UserProductApplication.services;



import com.example.UserProductApplication.domain.User;

import java.util.List;

public interface UserProductServices {
     User addUser(User user);
    boolean deleteById(String id);
}
