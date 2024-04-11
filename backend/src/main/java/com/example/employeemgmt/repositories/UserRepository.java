package com.example.employeemgmt.repositories;

import com.example.employeemgmt.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsById(Long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User save(User user);

    List<User> findAll();

    void deleteById(Long id);

    Page<User> findByUsername(String searchValue, Pageable pageable);

    Page<User> findByFirstName(String searchValue, Pageable pageable);

    Page<User> findByEmail(String searchValue, Pageable pageable);

    Page<User> findByJoinDate(String searchValue, Pageable pageable);

    Page<User> findByLastName(String searchValue, Pageable pageable);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
