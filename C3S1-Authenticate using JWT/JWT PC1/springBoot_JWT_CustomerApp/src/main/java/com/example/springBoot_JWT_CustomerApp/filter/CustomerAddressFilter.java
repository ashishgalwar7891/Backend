package com.example.springBoot_JWT_CustomerApp.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CustomerAddressFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        String authHeader=httpServletRequest.getHeader("authorization");

        if (authHeader==null || !authHeader.startsWith("Bearer")) {
            throw new ServletException("Token is Missing");
        }
        else{
            String tok=authHeader.substring(7);
            Claims claims= Jwts.parser().setSigningKey("privateKey").parseClaimsJws(tok).getBody();
            System.out.println(claims);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

}
