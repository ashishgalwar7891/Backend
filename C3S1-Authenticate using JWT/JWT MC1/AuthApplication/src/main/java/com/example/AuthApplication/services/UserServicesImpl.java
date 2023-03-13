package com.example.AuthApplication.services;

import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User checkLogin(User user)  {

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
