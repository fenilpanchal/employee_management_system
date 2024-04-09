package com.example.employeemgmt.repositories;

import com.example.employeemgmt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    User save(User user);

    List<User> findAll();
    void deleteById(Long id);
}