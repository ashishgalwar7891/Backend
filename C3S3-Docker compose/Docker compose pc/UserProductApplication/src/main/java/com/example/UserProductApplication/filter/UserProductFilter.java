package com.example.UserProductApplication.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class UserProductFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;

        String authHeader=httpServletRequest.getHeader("authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            throw new ServletException("Token is Missing");
        }
        else
        {
            String tok=authHeader.substring(7); //Bearer asdfg.zxcvbnfgh.cvghbh
            Claims claims= Jwts.parser().setSigningKey("secretKeyForWave37").parseClaimsJws(tok).getBody();
            System.out.println("claims retrivbed from token : "+claims);
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }

    }
}
