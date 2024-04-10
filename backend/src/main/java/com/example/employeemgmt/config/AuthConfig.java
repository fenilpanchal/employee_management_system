package com.example.employeemgmt.config;

import com.example.employeemgmt.utils.CookieUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Configuration
@Slf4j
public class AuthConfig extends OncePerRequestFilter {

    private final List<String> EXCLUDED_URL = List.of("/login");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (EXCLUDED_URL.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        } else if (!CookieUtils.isCookieExist(request, "user")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is unauthorized");
            filterChain.doFilter(request, response);
            return; //   <--- important line
        }
        filterChain.doFilter(request, response);
    }
}
