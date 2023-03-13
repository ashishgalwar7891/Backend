package com.MusicApplication.UserAuthenticationServices.services;

import com.MusicApplication.UserAuthenticationServices.domain.User;
import com.MusicApplication.UserAuthenticationServices.exception.UserAlreadyExistException;
import com.MusicApplication.UserAuthenticationServices.exception.UserNotFoundException;

public interface UserServices {
    User saveUser(User user) throws UserAlreadyExistException;
    User findByUserIdAndPassword(String userId,String password) throws UserNotFoundException;

}
