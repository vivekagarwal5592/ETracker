package com.start.ExpenseTracker.Model;



import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "expenses")
public class Expense {

	@GeneratedValue
	@Id
	private Integer id;
	private Float amount;
	
	@Temporal(TemporalType.DATE)
	private Date expenseDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private User userDetails;
	
	private String description;
	private String category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="groupid")
	private Group groupDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}


	public Date getDate() {
		return expenseDate;
	}

	public void setDate(Date date) {
		this.expenseDate = date;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public Group getGroupDetails() {
		return groupDetails;
	}

	public void setGroupDetails(Group groupDetails) {
		this.groupDetails = groupDetails;
	}

	public Date getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	
	
	
	

}
