package com.example.employeemgmt.services;

import com.example.employeemgmt.models.User;
import com.example.employeemgmt.models.UserSearchRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    //Create Employee
    User saveEmployee(User user);

    //Read an individual employee
    Page<User> searchEmployees(UserSearchRequest employee);

    Optional<User> findById(Long id);

    //Delete
    void deleteEmployeeById(Long id);

    Optional<User> findByUsernameAndPassword(String username, String password);
}

