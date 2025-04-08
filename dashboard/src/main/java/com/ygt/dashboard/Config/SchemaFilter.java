package com.ygt.dashboard.Config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SchemaFilter extends OncePerRequestFilter{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    protected void doFilterInternal(HttpServletRequest request, 
    HttpServletResponse response, 
    FilterChain filterChain) throws ServletException , IOException{
        String schema = request.getHeader("X-Schema"); 
        if (schema != null) {
            entityManager.createNativeQuery("SET search_path TO " + schema).executeUpdate(); 
        }
        filterChain.doFilter(request, response); 
    }
}
