package com.example.AuthApp.service;

import com.example.AuthApp.domain.User;
import com.example.AuthApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User checkLogin(User user) {
         //return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(userRepository.findById(user.getEmail()).isPresent())
        {
            User u=userRepository.findById(user.getEmail()).get();
            if(u.getPassword().equals(user.getPassword()))
            {
                return u;
            }
            else
            {
                return null;
            }
        }
        return null;
    }
}




