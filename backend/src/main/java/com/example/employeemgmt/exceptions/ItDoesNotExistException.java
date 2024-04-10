package com.example.employeemgmt.exceptions;

public class ItDoesNotExistException extends RuntimeException {
    public ItDoesNotExistException(String message) {
        super(message);
    }
}
