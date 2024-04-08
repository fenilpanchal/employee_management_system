package com.stevenhornghub.promotionrequest.repositories;


import com.stevenhornghub.promotionrequest.models.User;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Page<User> findByFirstName(String searchValue,Pageable pageable);
    Page<User> findByEmail(String searchValue, Pageable pageable);
    Page<User> findByJoinDate(String searchValue,Pageable pageable);
    Page<User> findByLastName(String searchValue, Pageable pageable);
}
