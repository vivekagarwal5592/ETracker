package springmvc.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;



@Table(name = "groups")
public class Group {
	
	String name;
	Integer groupid;
	ArrayList<User> userDetails;
	
	public Group() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGroupid() {
		return groupid;
	}
	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	public ArrayList<User> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(ArrayList<User> userDetails) {
		this.userDetails = userDetails;
	}
	
	

}
