package com.example.employeemgmt.services;

import com.example.employeemgmt.models.User;

import java.util.Optional;

public interface LoginService {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Boolean findByUserName(String username);

    Boolean checkPassword(String username);

    Optional<User> findByFirstName(String firstName);


}
