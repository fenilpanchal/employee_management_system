package com.example.employeemgmt.controllers;

import com.example.employeemgmt.models.User;
import com.example.employeemgmt.services.UserService;
import com.example.employeemgmt.utils.CookieUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/", allowedHeaders = "*")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletResponse httpServletResponse) {
        Optional<User> optionalUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        optionalUser.ifPresent(value -> httpServletResponse.addCookie(CookieUtils.setCookie("user", value.getUsername())));
        return optionalUser.orElse(null);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AccessDeniedException {
        Cookie[] cookies = CookieUtils.removeCookie(httpServletRequest);
        for (Cookie cookie : cookies) {
            httpServletResponse.addCookie(cookie);
        }
        return ResponseEntity.ok().build();
    }
}
