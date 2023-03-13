package com.MusicApplication.UserAuthenticationServices.controller;

import com.MusicApplication.UserAuthenticationServices.domain.User;
import com.MusicApplication.UserAuthenticationServices.exception.UserAlreadyExistException;
import com.MusicApplication.UserAuthenticationServices.exception.UserNotFoundException;
import com.MusicApplication.UserAuthenticationServices.filter.SecurityTokenGenerator;
import com.MusicApplication.UserAuthenticationServices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserServices userServices;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserServices userServices, SecurityTokenGenerator securityTokenGenerator) {
        this.userServices = userServices;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    //http://localhost:4445/api/v1/user
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistException {
        return new ResponseEntity<>(userServices.saveUser(user), HttpStatus.CREATED);
    }
    //http://localhost:4445/api/v1/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException
    {
        if(userServices.findByUserIdAndPassword(user.getUserId(),user.getPassword())!=null)
        {
            return new ResponseEntity<>(securityTokenGenerator.generateToken(user),HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("User Not Found",HttpStatus.EXPECTATION_FAILED);
        }
    }
}

