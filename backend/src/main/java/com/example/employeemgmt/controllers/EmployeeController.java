package com.example.employeemgmt.controllers;


import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
import com.example.employeemgmt.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


/**
 * @author Steven Horng
 */


@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @PostMapping("/search/{id}")
//    public Optional<User> fetchInfoById(@Valid @PathVariable("id") Long id) {
//        return employeeService.fetchEmployeeInfo(id);
//    }

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
                                      HttpServletRequest request) {
        return employeeService.searchEmployees(userSearchRequest);
    }

    @PutMapping("/update/{id}")
    public User updateEmployee(@Valid @PathVariable(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        return employeeService.updateEmployee(user);
    }

    //Delete for Employees
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted Successfully";
    }

}