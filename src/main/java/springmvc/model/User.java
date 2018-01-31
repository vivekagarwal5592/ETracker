package springmvc.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@JoinColumn(name = "userid")
	private Integer id;
	private String username;
	private String password;
	private String email;
	private int phone;
	private String registration_token;

//	@OrderColumn(name = "friend_order")

	@OneToMany(mappedBy = "user")
	private Set<Friend> friendDetails;

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

	public Set<Friend> getFriendDetails() {
		return friendDetails;
	}

	public void setFriendDetails(Set<Friend> friendDetails) {
		this.friendDetails = friendDetails;
	}

}