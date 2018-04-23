package com.start.ExpenseTracker.Dao;

import java.util.List;
import java.util.Set;

import com.start.ExpenseTracker.Model.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getUsers();

	void deleteUser(Integer id);

	User editUser(User user);

	User registerUser(User user);

	List<User> getFriendList(User user);

	User authenticateUser(User user);

	User getUser(String email);

	// Integer setFriend(User user);

	Integer setFriend(User user, User friend);

	List<User> getGroupUsers(String groupname);

}
