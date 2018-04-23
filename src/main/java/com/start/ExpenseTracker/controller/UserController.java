package com.start.ExpenseTracker.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.constraintvalidators.hv.URLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.start.ExpenseTracker.Dao.ExpenseDao;
import com.start.ExpenseTracker.Dao.GroupDao;
import com.start.ExpenseTracker.Dao.UserDao;
import com.start.ExpenseTracker.Model.Expense;
import com.start.ExpenseTracker.Model.Group;
import com.start.ExpenseTracker.Model.User;

@RestController
@SessionAttributes("Sessionuser")
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ExpenseDao expenseDao;

	@Autowired
	private GroupDao groupDao;

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		// models.put("useryyy", new User());
		return "login";
	}

	@RequestMapping(value = "/user/getallusers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("getallusers");

		List<User> users = userDao.getUsers();
		return new ResponseEntity<List<User>>(users, getResponseHeaders(), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/user/login", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" })
	// public User login(@RequestBody User user) {
	public User login(@RequestBody String username, @RequestBody String password) {

		// String username ="vivek";String password = "vivek";
		System.out.println("Unauthorized User");
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);

		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);

		User us = userDao.authenticateUser(u);
		// System.out.println("I am in login post function");
		// System.out.println(Sessionuser.getUsername());
		if (us != null) {
			return us;
			// (null, getResponseHeaders(), HttpStatus.CREATED);
		} else {
			System.out.println("Unauthorized User");
			return us;
			// return new ResponseEntity<User>(null, getResponseHeaders(),
			// HttpStatus.CREATED);
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/user/profile/{id}", method = RequestMethod.GET)
	public User getUserProfile(@RequestBody User user, @PathVariable Integer id) {

		if (user.getId() == id) {
			return user;
		} else {
			return null;
		}

	}

	/*
	 * @RequestMapping("/user/getallfriends") public List<User>
	 * getallfriends(@ModelAttribute("Sessionuser") User Sessionuser, ModelMap
	 * models) {
	 * 
	 * User user = userDao.getUser(Sessionuser.getId()); List<User> friends =
	 * user.getFriends(); return friends;
	 * 
	 * }
	 */

	@RequestMapping("/user/getallfriends")
	public List<User> getallfriends(ModelMap models) {

		User user = userDao.getUser(1);
		List<User> friends = user.getFriends();
		return friends;

	}

	@RequestMapping("/user/getallgroups")
	public List<Group> getallgroups(ModelMap models) {
		// User user = userDao.getUser(.getId());
		// List<Group> groups = user.getGps();
		// return groups;
		return null;
	}

	@RequestMapping("/user/getallexpenses")
	public List<Expense> getallexpenses(@ModelAttribute("user") User user) {
		// User user = userDao.getUser(Sessionuser.getId());
		List<Expense> expenses = user.getExpenses();
		return expenses;

	}

	/*
	 * @RequestMapping(value = "/user/edituser", method = RequestMethod.GET) public
	 * User editUser(@ModelAttribute("user") User user) { User Sessionuser = (User)
	 * models.get("Sessionuser");
	 * System.out.println("Id of the user in get method is  " +
	 * Sessionuser.getId()); // (User)models.get("Sessionuser") return Sessionuser;
	 * 
	 * }
	 */

	@RequestMapping(value = "/user/edituser", method = RequestMethod.POST)
	public User editUser(@ModelAttribute("user") User user, @RequestBody User u) {
		Integer id = user.getId();
		user = u;
		user.setId(id);
		return userDao.registerUser(user);

	}

	/*
	 * @RequestMapping(value = "/user/addfriend", method = RequestMethod.GET) public
	 * String addFriend(ModelMap models) { models.put("friend", new User()); return
	 * "addfriend"; }
	 */

	@RequestMapping(value = "/user/addfriend", method = RequestMethod.POST)
	public User addFriend(@ModelAttribute("Sessionuser") User Sessionuser, @RequestParam String email,
			BindingResult result) {
		User user = userDao.getUser(Sessionuser.getId());
		User friend = userDao.getUser(email);
		user.getFriends().add(friend);
		user = userDao.registerUser(user);
		return user;
	}

	@RequestMapping(value = "/user/addexpense", method = RequestMethod.GET)
	public List<Group> addExpense(@ModelAttribute("Sessionuser") User Sessionuser, ModelMap models) {
		// models.put("expense", new Expense());
		return Sessionuser.getGps();

	}

	@RequestMapping(value = "/user/addexpense", method = RequestMethod.POST)
	public List<Expense> addExpense(@ModelAttribute("Sessionuser") User Sessionuser, @RequestBody Expense expense) {
		System.out.println(expense.getCategory());
		User user = userDao.getUser(Sessionuser.getId());
		return user.getExpenses();
	}

	/*
	 * @RequestMapping(value = "/user/addgroup", method = RequestMethod.GET) public
	 * String addGroup(ModelMap models) { models.put("group", new Group()); return
	 * "addgroup"; }
	 */

	/*
	 * @RequestMapping(value = "/user/addgroup.html", method = RequestMethod.POST)
	 * public User addGroup(@ModelAttribute("Sessionuser") User
	 * Sessionuser, @ModelAttribute Group group, BindingResult result) { User user =
	 * userDao.getUser(Sessionuser.getId()); user.getGps().add(group); user =
	 * userDao.registerUser(user); return user; }
	 */

	@RequestMapping(value = "/user/addgroup.html", method = RequestMethod.POST)
	public User addGroup(HttpSession session, @ModelAttribute Group group, BindingResult result) {

		User user = userDao.getUser(((User) session.getAttribute("Sessionuser")).getId());
		user.getGps().add(group);
		user = userDao.registerUser(user);
		return user;
	}

	@RequestMapping(value = "/user/addgroupmember.html", method = RequestMethod.GET)
	public User addGroupMember(@ModelAttribute("Sessionuser") User Sessionuser, ModelMap models) {
		return userDao.getUser(Sessionuser.getId());

	}

	@RequestMapping(value = "/user/addgroupmember.html", method = RequestMethod.POST)
	public User addGroupMember(@RequestParam Integer friendid, @RequestParam Integer groupid) {
		User user = userDao.getUser(friendid);
		Group group = groupDao.getSingleGroupDetails(groupid);
		user.getGps().add(group);
		return userDao.registerUser(user);

	}

	public HttpHeaders getResponseHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		return responseHeaders;

	}

}