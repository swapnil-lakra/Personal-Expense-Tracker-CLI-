package com.expensetracker.service;

import com.expensetracker.exception.ExpenseNotFoundException;
import com.expensetracker.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    List<Expense> expenses;
    Map<Integer, Expense> expenseById;
    int nextId;

    ExpenseManager(){
        expenses = new ArrayList<>();
        expenseById = new HashMap<>();
        nextId = 1001;
    }

    Expense addExpense(double amount,Category category, LocalDate date, String description){
        Expense expense = new Expense(nextId, amount, category, date, description);
        expenses.add(expense);
        expenseById.put(expense.getId(), expense);
        return expense;
    }

    List<Expense> getAllExpenses(){
        return new ArrayList<>(expenses);
    }

    Expense getExpenseById(int id) throws ExpenseNotFoundException {
        Expense expense = expenseById.get(id);
        if(expense == null){
            throw new ExpenseNotFoundException("Expense with ID "+id+" not found.");
        }
        return expense;
    }

}
