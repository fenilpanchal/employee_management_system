//package com.stevenhornghub.promotionrequest.repositories;
//
//import com.stevenhornghub.promotionrequest.models.Managers;
//import com.stevenhornghub.promotionrequest.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface ManagerRepository extends JpaRepository<User, Long> {
//
//    @Query("from User")
//    List<User> findAllUsers();
//
//    boolean existsByUsername(String username);
//
//    boolean existsByEmail(String email);
//
//    Managers save(Managers managers);
//
//    boolean existsById(Long id);
//
//    void deleteById(Long id);
//}
