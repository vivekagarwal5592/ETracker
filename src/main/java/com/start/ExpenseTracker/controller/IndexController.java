package com.start.ExpenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.start.ExpenseTracker.Dao.UserDao;
import com.start.ExpenseTracker.Model.User;

@Controller
@SessionAttributes("Sessionuser")
public class IndexController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/index.html")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(ModelMap models) {
		models.put("useryyy", new User());
		return "login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, ModelMap models) {
		// System.out.println(Sessionuser.getUsername());
		User u = userDao.authenticateUser(user);
		// System.out.println("I am in login post function");
		// System.out.println(Sessionuser.getUsername());
		if (u != null) {
			models.put("Sessionuser", u);
			// System.out.println(Sessionuser.getEmail());
			return "redirect:user/getuserdetails.html";
		} else {
			System.out.println("I am in post method 2");
			return "login";
		}

	}

	@RequestMapping(value = "registeruser.html", method = RequestMethod.GET)
	public String addUser(ModelMap models) {
		models.put("user", new User());
		return "registeruser";
	}

	@RequestMapping(value = "registeruser.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user, BindingResult result) {

		// userValidator.validate(user, result);
		// if (result.hasErrors()) {
		// return "adduser";
		// }

		user = userDao.registerUser(user);
		return "redirect:login.html";
	}

	@ModelAttribute("Sessionuser")
	public User adduserToSession() {
		// System.out.println("I am in addUser to session");
		User u = new User();
		// u.setUsername("abc");
		return u;
	}

}
