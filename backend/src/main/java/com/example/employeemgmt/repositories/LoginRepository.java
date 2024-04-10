package com.example.employeemgmt.repositories;

import com.example.employeemgmt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, Long> {
    Boolean existsByPassword(String password);

    Boolean existsByUsername(String username);

    Boolean existsByUsernameAndPassword(String username, String password);

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByFirstName(String firstName);


}