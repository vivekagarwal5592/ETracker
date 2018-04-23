package com.start.ExpenseTracker.Dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.start.ExpenseTracker.Dao.UserDao;
import com.start.ExpenseTracker.Model.User;



@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		return entityManager.createQuery("from User order by id", User.class).getResultList();
	}

	@Override
	public void deleteUser(Integer id) {

	}

	@Override
	@Transactional
	public User editUser(User user) {
		return null;
	}

	@Override
	@Transactional
	public User registerUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public List<User> getFriendList(User u) {
		User user = new User();
		return entityManager.createQuery("from User where id = :id", User.class).setParameter("id", user.getId())
				.getResultList();

	}

	@Override
	public User authenticateUser(User user) {

		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		User u = entityManager.createQuery("from User where  username= :username and password =:password", User.class)
				.setParameter("username", user.getUsername()).setParameter("password", user.getPassword())
				.getSingleResult();
		if (u == null) {
			System.out.println("I have not found user");
			return null;
		} else {
			System.out.println("I have found user");
			return u;
		}
	}

	@Override
	public User getUser(String email) {
		return entityManager.createQuery("from User where email = :email", User.class).setParameter("email", email)
				.getSingleResult();
	}

	@Override
	@Transactional
	public Integer setFriend(User user, User friend) {
		System.out.println(user.getFriends().size());

		return 0;

		// return entityManager.createQuery("update User set friends = (:friends)")
		// .setParameter("friends", user.getFriends()).executeUpdate();

	}

	@Override
	public List<User> getGroupUsers(String groupname) {
		return entityManager.createQuery("from User join gps where gps.groupname = :groupname", User.class)
				.setParameter("groupname", groupname).getResultList();
	}

}
