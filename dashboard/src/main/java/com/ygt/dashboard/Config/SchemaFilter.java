package com.ygt.dashboard.Config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Statement;

@Component
public class SchemaFilter extends OncePerRequestFilter{


    @Autowired
    private DataSource dataSource;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {

        String schema = request.getHeader("X-Schema");

        if (schema != null && !schema.isEmpty()) {
            try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {

                statement.execute("SET search_path TO " + schema);

            } catch (SQLException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\":\"Invalid schema: " + schema + "\"}");
                return; 
            }
        }

        filterChain.doFilter(request, response);
    }  

}
