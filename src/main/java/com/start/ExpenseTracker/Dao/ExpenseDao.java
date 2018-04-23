package com.start.ExpenseTracker.Dao;

import java.util.List;

import com.start.ExpenseTracker.Model.Expense;
import com.start.ExpenseTracker.Model.User;

public interface ExpenseDao {

	List<Expense> getallExpenses(User user);

	Expense addExpense(Expense expense);

	void deleteExpense(Expense expense);

	void editExpense(Expense expense);

	Expense getSingleExpense(Integer id);

}
