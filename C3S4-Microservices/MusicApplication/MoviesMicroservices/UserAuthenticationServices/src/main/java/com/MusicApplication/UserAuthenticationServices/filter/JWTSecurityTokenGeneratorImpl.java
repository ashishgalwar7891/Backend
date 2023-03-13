package com.MusicApplication.UserAuthenticationServices.filter;

import com.MusicApplication.UserAuthenticationServices.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTSecurityTokenGeneratorImpl implements SecurityTokenGenerator {
//    @Override
//    public String createToken(User user) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("UserId", user.getUserId());
//        return generateToken(claims,user.getUserId());
//    }
    @Override
    public Map<String,String> generateToken(User user){
        Map<String,String> result=new HashMap<>();
        Map<String,Object> userData=new HashMap<>();
        user.setPassword("");
        userData.put("User",user);
        String newJwt=Jwts.builder().setClaims(userData).setIssuer(String.valueOf(new Date())).signWith(SignatureAlgorithm.HS512,"mykey").compact();
        result.put("Token",newJwt);
        result.put("Message","User Successfully Login In");
        return result;
    }

}


