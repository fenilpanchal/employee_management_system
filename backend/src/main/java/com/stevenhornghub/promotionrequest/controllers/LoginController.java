package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.services.LoginService;
import com.stevenhornghub.promotionrequest.utils.CookieUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;
import java.util.Optional;


@RestController
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletResponse httpServletResponse) {
        Optional<User> optionalUser = loginService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        optionalUser.ifPresent(value -> httpServletResponse.addCookie(CookieUtils.setCookie("user", value.getUsername())));
        return optionalUser.orElse(null);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AccessDeniedException {
        Cookie[] cookies = CookieUtils.removeCookie(httpServletRequest);
        for (Cookie cookie: cookies) {
            httpServletResponse.addCookie(cookie);
        }
        return ResponseEntity.ok().build();
    }
}
