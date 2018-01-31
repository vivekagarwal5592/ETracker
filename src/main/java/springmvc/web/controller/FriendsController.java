package springmvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Friend;
import springmvc.model.User;
import springmvc.model.dao.FriendDao;
import springmvc.model.dao.UserDao;

@Controller
public class FriendsController {

	@Autowired
	private FriendDao friendDao;

	@RequestMapping("friend/getallfriends.html")
	public String getallfriends(ModelMap models) {

		User user = new User();
		Friend friendList = friendDao.friendList(user);
		models.put("friends", friendList);

		System.out.println("I am in getallfriendscontroller");

		return "getallfriends";
	}

	@RequestMapping(value = "friend/addfriend.html", method = RequestMethod.GET)
	public String addfriend() {
		// models.put("friend", new Friend());
		return "addfriend";
	}

	@RequestMapping(value = "friend/addfriend.html", method = RequestMethod.POST)
	public String addfriend(String email) {
		// models.put("friend", new Friend());
		return "addfriend";
	}

	@RequestMapping("/addgroup.html")
	public String addgroup() {
		return "addgroup";
	}

}
