package com.example.UserProductApp.controller;

import com.example.UserProductApp.domain.User;
import com.example.UserProductApp.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class UserProductController
{
    @Autowired
    private UserProductService userProductService;

    // http://localhost:5555/product/addUser  [Post]
    @PostMapping("/addUser")
    public ResponseEntity<?> addUserProduct(@RequestBody User user)
    {
//        user.setProducts(new ArrayList<>());
        return new ResponseEntity<>(userProductService.addUser(user), HttpStatus.OK);
    }

    // http://localhost:5555/product/getUsers [get]
    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUser(HttpServletRequest request)throws ServletException
    {
        String email=(String)request.getAttribute("attribute1");
        System.out.println(email);

        String role=(String)request.getAttribute("attribute2");

//        if(role.equals("admin")) {
            return new ResponseEntity<>(userProductService.getAllUser(email), HttpStatus.OK);
//        }
//        else
//        {
//            throw new ServletException("Only admin can access");
//        }
    }


}
