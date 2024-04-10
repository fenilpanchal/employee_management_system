package com.example.employeemgmt.exceptions;

public class UsernameDoesNotExistException extends RuntimeException {
    public UsernameDoesNotExistException(String message) {
        super(message);
    }
}

