package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.services.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        Optional<User> optionalUser = loginService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return optionalUser.orElse(null);
    }

    @PostMapping("/logout")
    public ResponseEntity logout() {
        return ResponseEntity.ok().build();
    }
}
