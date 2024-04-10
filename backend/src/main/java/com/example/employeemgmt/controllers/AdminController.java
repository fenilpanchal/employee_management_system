package com.example.employeemgmt.controllers;

import com.example.employeemgmt.models.SignUpDto;
import com.example.employeemgmt.models.User;
import com.example.employeemgmt.repositories.SignupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin")

public class AdminController {

    private final SignupRepository signupRepository;

    public AdminController(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }

    @PostMapping("/employee/add")
    public ResponseEntity<?> registerEmployee(@RequestBody SignUpDto dto) {

        if (signupRepository.existsByUsername(dto.getUsername())) {
            return ResponseEntity.badRequest().body(Map.of("error", "Username is already taken!"));
        }
        if (signupRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email is already taken!"));
        }
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        user = signupRepository.save(user);
        return ResponseEntity.ok(Map.of("user", user));
    }

}


