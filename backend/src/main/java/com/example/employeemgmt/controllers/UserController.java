package com.example.employeemgmt.controllers;

import com.example.employeemgmt.models.User;
import com.example.employeemgmt.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Steven Horng
 */
@Slf4j
@RestController
@RequestMapping("/users")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> fetchUserList(@Valid @RequestParam int pageNumber, @RequestParam int pageSize) {
        return new ResponseEntity<>(userService.fetchUserList(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getListUser() {
        List<User> list = userService.getListUser();
        ResponseEntity<List<User>> showListUser = new ResponseEntity<>(list, HttpStatus.OK);
        return showListUser;
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable(value = "id") Long id,
                                           @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user, id);
        return ResponseEntity.ok(user);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@Valid @PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "Deleted Successfully";
    }


}
