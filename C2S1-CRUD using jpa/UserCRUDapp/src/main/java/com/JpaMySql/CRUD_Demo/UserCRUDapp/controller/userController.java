package com.JpaMySql.CRUD_Demo.UserCRUDapp.controller;

import com.JpaMySql.CRUD_Demo.UserCRUDapp.domain.User;
import com.JpaMySql.CRUD_Demo.UserCRUDapp.serivces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class userController {
    private final UserService userService;
    @Autowired

    public userController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<?> getUSer(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.FOUND);
    }
    @GetMapping("/user/{lastname}")
    public ResponseEntity<?> getUserName(@PathVariable String lastname){
        return new ResponseEntity<>(userService.getUserByLastName(lastname),HttpStatus.FOUND);
    }
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUserByEmail(email),HttpStatus.ACCEPTED);

    }
    @PutMapping("/user/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String email){
        return new ResponseEntity<>(userService.updateUser(user,email),HttpStatus.GONE);
    }
}
