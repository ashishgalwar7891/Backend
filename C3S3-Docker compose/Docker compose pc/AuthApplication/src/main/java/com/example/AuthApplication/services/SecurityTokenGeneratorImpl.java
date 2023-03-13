package com.example.AuthApplication.services;

import com.example.AuthApplication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user){
        Map<String,String> result= new HashMap<String,String>();
        Map<String,Object> userData=new HashMap<String,Object>();
        user.setPassword("");
        userData.put("Users",user);
        String newJwt= Jwts.builder()
                .setClaims(userData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"secretKeyForWave37")
                .compact();

        result.put("Token",newJwt);
        result.put("Message","User Successfully Logged In");
        return result;
    }
}
