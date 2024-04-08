package com.stevenhornghub.promotionrequest.services;

import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.models.UserSearchRequest;
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

