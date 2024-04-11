package com.example.employeemgmt.controllers;

import com.example.employeemgmt.models.User;
import com.example.employeemgmt.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Steven Horng
 */
@RestController
@RequestMapping("/employees")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/", allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> fetchInfoById(@Valid @PathVariable("id") Long id) {
        return userService.findById(id);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable(value = "id") Long id,
                                           @RequestBody User user) {
        if (!id.equals(user.getId())) {
            throw new RuntimeException("Cannot change other employee details");
        }
        userService.saveEmployee(user);
        return ResponseEntity.ok(user);
    }

}