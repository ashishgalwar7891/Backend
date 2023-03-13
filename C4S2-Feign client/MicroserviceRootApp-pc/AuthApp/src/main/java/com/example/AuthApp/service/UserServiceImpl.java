package com.example.AuthApp.service;

import com.example.AuthApp.domain.SignUpData;
import com.example.AuthApp.domain.User;
import com.example.AuthApp.domain.UserDTO;
import com.example.AuthApp.proxy.Userproxy;
import com.example.AuthApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Userproxy userproxy;

    @Override
    public  User registerUser1(SignUpData signUpData){
        UserDTO userDTO=new UserDTO(signUpData.getEmail(),signUpData.getName(),signUpData.getAddress(),signUpData.getShippingAddress(),signUpData.getPhno());
        ResponseEntity response=userproxy.sendUserDataToProductApp(userDTO);
        System.out.println(response);

        User user=new User(signUpData.getEmail(),signUpData.getPassword(),"USER_ROLE");
        return  userRepository.save(user);
    }
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




