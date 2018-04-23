package com.start.ExpenseTracker.Dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.ExpenseTracker.Dao.ExpenseDao;
import com.start.ExpenseTracker.Model.Expense;
import com.start.ExpenseTracker.Model.User;



@Repository
public class ExpenseDaoImpl implements ExpenseDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Expense getSingleExpense(Integer id) {
		return entityManager.find(Expense.class, id);
	}
	
	
	@Override
	public List<Expense> getallExpenses(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Expense addExpense( Expense expense) {
		
		return entityManager.merge(expense);
		
	}

	@Override
	public void deleteExpense(Expense expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editExpense( Expense expense) {
		// TODO Auto-generated method stub
		
	}

}
