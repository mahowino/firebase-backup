package com.example.demo.patient.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super("The Database went through a fault");
    }
}
