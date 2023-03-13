package com.example.userauthapp.service;

import com.example.userauthapp.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result = new HashMap<>();
        Map<String, Object> claims = new HashMap<>();
        user.setPassword("");
        claims.put("Username", user.getUsername());
        String newJWT = Jwts.builder().setClaims(claims).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"secretkey").compact();
        result.put("token", newJWT);
        result.put("message", "User successfully logged in");
        return result;
    }


}
