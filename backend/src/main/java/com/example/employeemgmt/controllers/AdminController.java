package com.example.employeemgmt.controllers;
import com.example.employeemgmt.repositories.SignupRepository;
import com.example.employeemgmt.models.SignUpDto;
import com.example.employeemgmt.models.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminController {

    private final SignupRepository signupRepository;
    public AdminController(SignupRepository signupRepository) {
        this.signupRepository= signupRepository;
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

        signupRepository.save(user);
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        return ResponseEntity.ok(Map.of("error", "User registered successfully!"));
    }

}


