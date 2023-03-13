package com.example.usertrack.filter;

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

public class UserMusicFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String authHeader = httpServletRequest.getHeader("authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer")){
            throw new ServletException("Invalid token");
        }
        else{
            String tok = authHeader.substring(7);
            Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(tok).getBody();
            System.out.println("Claims retrieved from token: "+claims);
            httpServletRequest.setAttribute("attribute1",claims.get("Username"));
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }
}
