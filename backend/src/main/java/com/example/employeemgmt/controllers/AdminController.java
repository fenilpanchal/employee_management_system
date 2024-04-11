package com.example.employeemgmt.controllers;

import com.example.employeemgmt.models.SignUpDto;
import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
import com.example.employeemgmt.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/", allowedHeaders = "*")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/employees/add")
    public ResponseEntity<?> registerEmployee(@RequestBody SignUpDto dto) {

        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user = userService.saveEmployee(user);
        return ResponseEntity.ok(Map.of("user", user));
    }

    /**
     * {
     * searchBy: e.g firstName, lastName, email, joinDate,
     * sortBy: FirstName (Default), last name etc
     * offset: 0,
     * limit: 10
     * }
     *
     * @param userSearchRequest
     * @return
     */
    @PostMapping("/search")
    public Page<User> searchEmployees(@Valid @RequestBody UserSearchRequest userSearchRequest,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) {
        return userService.searchEmployees(userSearchRequest);
    }

//    @PutMapping("/update/{id}")
//    public User updateEmployee(@Valid @PathVariable(value = "id") Long id, @RequestBody User user) {
//        user.setId(id);
//        return userService.updateEmployee(user);
//    }

    //Delete for Employees
    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable("id") Long id) {
        userService.deleteEmployeeById(id);
        return ResponseEntity.ok(Map.of("message", "Deleted Successfully"));
    }

}


