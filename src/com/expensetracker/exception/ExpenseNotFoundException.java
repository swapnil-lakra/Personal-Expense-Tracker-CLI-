package com.expensetracker.exception;

public class ExpenseNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ExpenseNotFoundException(String message){
        super(message);
    }

    public ExpenseNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}
