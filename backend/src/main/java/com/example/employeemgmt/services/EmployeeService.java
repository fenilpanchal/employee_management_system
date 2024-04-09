package com.example.employeemgmt.services;

import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface EmployeeService {

    //Create Employee
    User saveEmployee(User user);

    //Read an individual employee
    Page<User> searchEmployees(UserSearchRequest employee);

    Optional<User> fetchEmployeeInfo(Long id);

    //Update
    User updateEmployee(User user);

    //Delete
    void deleteEmployeeById(Long id);

}

