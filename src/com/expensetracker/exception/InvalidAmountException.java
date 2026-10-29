package com.expensetracker.exception;

public class InvalidAmountException extends Exception {
    private static final long serialVersionUID = 1L;
    
    InvalidAmountException(String message){
        super(message);
    }

    InvalidAmountException(String message,Throwable cause){
        super(message,cause);
    }
}
