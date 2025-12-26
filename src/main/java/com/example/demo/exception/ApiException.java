package com.example.demo.exception;

public class ApiException extends RuntimeException {

    // Existing no-args constructor
    public ApiException() {
        super();
    }

    // Add this constructor to accept message
    public ApiException(String message) {
        super(message);
    }
}