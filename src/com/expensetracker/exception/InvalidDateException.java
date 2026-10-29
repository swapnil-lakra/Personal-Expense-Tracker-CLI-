package com.expensetracker.exception;

public class InvalidDateException extends Exception {
    private static final long serialVersionUID = 1L;

    InvalidDateException(String message){
        super(message);
    }

    InvalidDateException(String message, Throwable cause){
        super(message, cause);
    }
}
