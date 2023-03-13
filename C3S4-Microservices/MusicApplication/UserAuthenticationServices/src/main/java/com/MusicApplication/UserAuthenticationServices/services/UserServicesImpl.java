package com.MusicApplication.UserAuthenticationServices.services;

import com.MusicApplication.UserAuthenticationServices.domain.User;
import com.MusicApplication.UserAuthenticationServices.exception.UserAlreadyExistException;
import com.MusicApplication.UserAuthenticationServices.exception.UserNotFoundException;
import com.MusicApplication.UserAuthenticationServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{

    private UserRepository userRepository;
    @Autowired
    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if(userRepository.findById(user.getUserId()).isPresent())
        {
            throw new UserAlreadyExistException();
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User findByUserIdAndPassword(String userId,String password) throws UserNotFoundException {
        System.out.println("userId"+userId);
        System.out.println("password"+password);
        User loggedInUser = userRepository.findByUserIdAndPassword(userId,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new UserNotFoundException();
        }

        return loggedInUser;
    }

}
