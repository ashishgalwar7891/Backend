package com.example.userauthapp.controller;

import com.example.userauthapp.domain.User;
import com.example.userauthapp.service.SecurityTokenGenerator;
import com.example.userauthapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

 @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody User user){
     return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
 }
 @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
     User userObj = userService.loginUser(user);
     if(userObj != null){
         Map<String, String> map = securityTokenGenerator.generateToken(userObj);
         return new ResponseEntity<>(map, HttpStatus.OK);
     }else{
         return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
     }
 }
}
