package com.example.AuthApp.controller;

import com.example.AuthApp.domain.SignUpData;
import com.example.AuthApp.domain.User;
import com.example.AuthApp.service.SecurityTokenGenerator;
import com.example.AuthApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    // http://localhost:4444/api/v1/register1  [post]
    @PostMapping("/register1")
    public  ResponseEntity<?> registerUser1(@RequestBody SignUpData signUpData){
        return new ResponseEntity<>(userService.registerUser1(signUpData),HttpStatus.OK);
    }

    // http://localhost:4444/api/v1/register  [post]
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setRole("USER-Role");
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.OK);
    }

    // http://localhost:4444/api/v1/login   [get]
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user)
    {
        User checkedUser=userService.checkLogin(user);
        if(checkedUser!=null) {
            return new ResponseEntity<>(securityTokenGenerator.generateToken(checkedUser),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Aunthentication failed....",HttpStatus.EXPECTATION_FAILED);
        }
    }
}