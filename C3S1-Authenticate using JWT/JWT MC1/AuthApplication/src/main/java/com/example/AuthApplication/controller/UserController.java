package com.example.AuthApplication.controller;

import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.services.SecurityTokenGenerator;
import com.example.AuthApplication.services.UserServices;
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

    @Autowired
    private UserServices userServices;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    // http://localhost:4444/api/v1/register  [post]
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setRole("USER-Role");
        return new ResponseEntity<>(userServices.registerUser(user), HttpStatus.OK);
    }

    // http://localhost:4444/api/v1/login   [get]
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user)
    {
        User checkedUser=userServices.checkLogin(user);
        if(checkedUser!=null) {
            return new ResponseEntity<>(securityTokenGenerator.generateToken(checkedUser),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Aunthentication failed....",HttpStatus.EXPECTATION_FAILED);
        }
    }
}
