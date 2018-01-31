package springmvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import springmvc.model.Friend;
import springmvc.model.User;
import springmvc.model.dao.UserDao;
import springmvc.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping("user/users.html")
	public String users(@RequestParam(required = false) Integer id, ModelMap models) {
		models.put("users", userDao.getUsers());
		return "users";
	}

	@RequestMapping("user/getuserdetails.html")
	public String getUserDetails(@RequestParam Integer id, ModelMap models) {
		models.put("user", userDao.getUser(id));
		return "getuserdetails";
	}

	@RequestMapping(value = "user/adduser.html", method = RequestMethod.GET)
	public String addUser(ModelMap models) {
		models.put("user", new User());
		return "adduser";
	}

	@RequestMapping(value = "user/adduser.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user, BindingResult result) {

		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "adduser";
		}

		user = userDao.registerUser(user);
		return "redirect:users.html";
	}

	@RequestMapping(value = "user/edituser.html", method = RequestMethod.GET)
	public String editUser(@RequestParam Integer id, ModelMap models) {
		models.put("user", userDao.getUser(id));
		return "edituser";
	}

	@RequestMapping(value = "user/edituser.html", method = RequestMethod.POST)
	public String editUser(@ModelAttribute User user, SessionStatus status) {
		user = userDao.registerUser(user);
		status.setComplete();
		return "redirect:users.html";
	}

	@RequestMapping("user/getallfriends.html")
	public String getallfriends(ModelMap models) {

		// (User) models.put("user", userDao.getUser(1));

		User user = userDao.getUser(1);

		// System.out.println(user.getUsername());

		// List<Friend> details =user.getFriendDetails();
		// List<User> friendList = userDao.getFriendList(user);
		// models.put("friends", friendList);

		for (int i = 0; i <= user.getFriendDetails().size() - 1; i++) {
			System.out.println("I am in friend detaisl");
	//		System.out.println(user.getFriendDetails().get(i).getId());
		}

		System.out.println("I am in getallfriendscontroller");

		return "getallfriends";
	}

}