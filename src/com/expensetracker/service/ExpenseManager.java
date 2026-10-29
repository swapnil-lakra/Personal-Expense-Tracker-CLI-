package com.expensetracker.service;

import com.expensetracker.exception.ExpenseNotFoundException;
import com.expensetracker.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private List<Expense> expenses;
    private Map<Integer, Expense> expenseById;
    private int nextId;

    public ExpenseManager(){
        expenses = new ArrayList<>();
        expenseById = new HashMap<>();
        nextId = 1001;
    }

    public Expense addExpense(double amount,Category category, LocalDate date, String description){
        Expense expense = new Expense(nextId, amount, category, date, description);
        expenses.add(expense);
        expenseById.put(expense.getId(), expense);
        return expense;
    }

    public List<Expense> getAllExpenses(){
        return new ArrayList<>(expenses);
    }

    public Expense getExpenseById(int id) throws ExpenseNotFoundException {
        Expense expense = expenseById.get(id);
        if(expense == null){
            throw new ExpenseNotFoundException("Expense with ID "+id+" not found.");
        }
        return expense;
    }

    public void updateExpense(int id, String field, Object newValue) throws ExpenseNotFoundException {
        Expense expense = getExpenseById(id);

        switch (field.toUpperCase()) {
            case "AMOUNT":
                expense.setAmount((Double) newValue);
                break;
            case "CATEGORY":
                expense.setCategory((Category) newValue);
                break;
            case "DATE":
                expense.setDate((LocalDate) newValue);
                break;
            case "DESCRIPTION":
                expense.setDescription((String) newValue);
                break;
            default:
                throw new IllegalArgumentException("Unknown update field: "+field);
        }
    }

    public boolean deleteExpense(int id){
        Expense removed = expenseById.remove(id);
        if(removed == null) return false;
        expenses.remove(removed.getId());
        return true;
    }

    public List<Expense> filterByCategory(Category category){
        List<Expense> result = new ArrayList<>();
        for(Expense e : expenses){
            if(e.getCategory() == category){
                result.add(e);
            }
        }
        return result;
    }

    public List<Expense> filterByDateRange(LocalDate from, LocalDate to){
        List<Expense> result = new ArrayList<>();
        for(Expense e: expenses){
            LocalDate d = e.getDate();
            if(!d.isBefore(from) && !d.isAfter(to)){
                result.add(e);
            }
        }
        return result;
    }

    public List<Expense> filterByKeyword(String keyword){
        List<Expense> result = new ArrayList<>();
        if(keyword == null || keyword.trim().isEmpty()){
            return result;
        }

        String lower = keyword.toLowerCase();
        for(Expense e: expenses){
            String desc = e.getDescription();
            if(desc != null && desc.toLowerCase().contains(lower)){
                result.add(e);
            }
        }
        return result;
    }

    public List<Expense> filterByAmountRange(double min,double max){
        List<Expense> result = new ArrayList<>();
        for(Expense e: expenses){
            double amount = e.getAmount();
            if(amount >= min && amount <= max){
                result.add(e);
            }
        }
        return result;
    }

}
