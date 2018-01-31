package springmvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class Friend implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@JoinColumn(name = "userid")
	@ManyToOne
	private User user;
	
	//@JoinColumn(name="friendid")
	//@ManyToOne
	private User friend;
	
//	private Integer friend;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		
		StringBuilder sb= new StringBuilder();
		sb.append(id);
	//	friendDetails.forEach(u -> sb.append(u.getEmail()));
		return sb.toString();
	}

}
