package com.start.ExpenseTracker.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

	@Id
	@GeneratedValue
	Integer id;
	String groupname;
	

	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
	@JoinTable(name = "user_group", joinColumns = { @JoinColumn(name = "groupid") }, inverseJoinColumns = {
			@JoinColumn(name = "userid") })
	@JsonIgnore
	 Set<User> userDetails = new HashSet<User>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="groupDetails")
	@JsonIgnore
	List<Expense> expenses;

	public Group() {
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	

	public Set<User> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Set<User> userDetails) {
		this.userDetails = userDetails;
	}

	public String getGroupName() {
		return this.groupname;
	}

	public void setGroupName(String name) {
		this.groupname = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
