package com.start.ExpenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.start.ExpenseTracker.Dao.ExpenseDao;
import com.start.ExpenseTracker.Model.Expense;




@Controller
public class ExpenseController {

	@Autowired
	private ExpenseDao expenseDao;

	@RequestMapping(value = "Expense/addexpense", method = RequestMethod.GET)
	public String addExpense(@ModelAttribute Expense expense,ModelMap model){
		
		return "addexpense";
	}
	
	
}
