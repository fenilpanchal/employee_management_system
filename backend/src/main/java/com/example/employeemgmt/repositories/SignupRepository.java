package com.example.employeemgmt.repositories;

import com.example.employeemgmt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignupRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String name);

    Optional<User> findByPassword(String password);

    Boolean existsByUsername(String name);

    Boolean existsByEmail(String email);

    Boolean existsByPassword(String password);

}
