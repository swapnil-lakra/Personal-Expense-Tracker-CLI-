package com.expensetracker.exception;

public class InvalidCategoryException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public InvalidCategoryException(String message){
        super(message);
    }

    public InvalidCategoryException(String message, Throwable cause){
        super(message,cause);
    }

}