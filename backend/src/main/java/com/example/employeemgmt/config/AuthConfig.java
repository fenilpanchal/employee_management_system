package com.example.employeemgmt.config;

import com.example.employeemgmt.utils.CookieUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Configuration
public class AuthConfig extends OncePerRequestFilter {

    private List<String> EXCLUDED_URL = List.of(
            "/login"
    );
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ( EXCLUDED_URL.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
        }
        if (!CookieUtils.isCookieExist(request, "user")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is unauthorized");
        }
        filterChain.doFilter(request, response);
    }
}
