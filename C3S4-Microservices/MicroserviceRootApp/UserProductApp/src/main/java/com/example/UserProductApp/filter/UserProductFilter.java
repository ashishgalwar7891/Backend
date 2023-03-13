package com.example.UserProductApp.filter;

import com.example.UserProductApp.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProductFilter extends GenericFilterBean
{
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
            Claims claims=Jwts.parser().setSigningKey("secretKeyForWave37").parseClaimsJws(tok).getBody();
            System.out.println("claims retrivbed from token : "+claims);

            httpServletRequest.setAttribute("attribute1",claims.get("UserEmail"));

            httpServletRequest.setAttribute("attribute2",claims.get("UserRole"));

            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }

    }
}
