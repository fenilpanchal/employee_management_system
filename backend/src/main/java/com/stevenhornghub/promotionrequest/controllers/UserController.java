package com.stevenhornghub.promotionrequest.controllers;

import com.stevenhornghub.promotionrequest.models.User;
import com.stevenhornghub.promotionrequest.services.UserService;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.List;

/**
 * @author Steven Horng
 */


@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    //new add



    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Save
    @PostMapping("/add")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    //Read
    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> fetchUserList(@Valid @RequestParam int pageNumber , @RequestParam int pageSize) {
        return new ResponseEntity<>(userService.fetchUserList(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getListUser (){
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
