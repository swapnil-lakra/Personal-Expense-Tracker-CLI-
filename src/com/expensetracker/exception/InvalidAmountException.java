package com.expensetracker.exception;

public class InvalidAmountException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InvalidAmountException(String message){
        super(message);
    }

    public InvalidAmountException(String message,Throwable cause){
        super(message,cause);
    }
}
