package com.stevenhornghub.promotionrequest.config;

import com.stevenhornghub.promotionrequest.utils.CookieUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
