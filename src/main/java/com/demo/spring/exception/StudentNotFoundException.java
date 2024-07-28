package com.demo.spring.exception;

public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(String message) {
        super(message);
    }
}
