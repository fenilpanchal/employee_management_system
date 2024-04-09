package com.example.employeemgmt.exceptions;

public class IdDoesNotExistException extends RuntimeException{
    public IdDoesNotExistException(String message) {
        super(message);
    }
}