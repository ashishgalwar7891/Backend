package com.example.AuthApp.proxy;

import com.example.AuthApp.domain.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="product-service",url="localhost:5555")
public interface Userproxy {

    // http://localhost:5555/product/addUser    [post]
    @PostMapping("/product/addUser")
    public ResponseEntity<?> sendUserDataToProductApp(@RequestBody UserDTO userDTO);
}
