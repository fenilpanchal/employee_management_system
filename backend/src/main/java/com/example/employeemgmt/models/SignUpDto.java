package com.example.employeemgmt.models;

import lombok.Data;

@Data
public class SignUpDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Long joinDate;
    private String email;
    private String password;
}
