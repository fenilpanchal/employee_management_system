package com.example.employeemgmt.exceptions;

public class CannotBeNullException extends RuntimeException {
    public CannotBeNullException(String message) {
        super(message);
    }
}
