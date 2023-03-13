package com.example.springBoot_JWT_AuthApp.services;

import com.example.springBoot_JWT_AuthApp.domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Customer customer){
        Map<String,String> result= new HashMap<>();
        Map<String,Object> customerData=new HashMap<>();
        customer.setPassword("");
        customerData.put("Customer",customer);
        String newJwt= Jwts.builder()
                .setClaims(customerData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"privateKey")
                .compact();

        result.put("Token",newJwt);
        result.put("Message","User Successfully Logged In");
        return result;
    }
}
