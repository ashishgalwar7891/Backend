package com.MusicApplication.UserAuthenticationServices.filter;

import com.MusicApplication.UserAuthenticationServices.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
//    String createToken(User user);
    Map<String,String> generateToken(User user);
}
