package com.start.ExpenseTracker.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;
	private String email;
	private int phone;
	private String registration_token;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "friends", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "friendid") })
	@JsonIgnore
	private List<User> user;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "friends", joinColumns = { @JoinColumn(name = "friendid") }, inverseJoinColumns = {
			@JoinColumn(name = "userid") })
	@JsonIgnore
	private List<User> friends;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "user_group", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "groupid") })
	@JsonIgnore
	private List<Group> gps;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userDetails")
	@JsonIgnore
	private List<Expense> expenses;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getRegistration_token() {
		return registration_token;
	}

	public void setRegistration_token(String registration_token) {
		this.registration_token = registration_token;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Group> getGps() {
		return gps;
	}

	public void setGps(List<Group> gps) {
		this.gps = gps;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

}