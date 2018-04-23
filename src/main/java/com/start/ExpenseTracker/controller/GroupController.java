package com.start.ExpenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.start.ExpenseTracker.Dao.GroupDao;



@Controller
public class GroupController {
	
	@Autowired
	private GroupDao groupDao;
	
	@RequestMapping("/getgroup.html")
	public String getgroup(ModelMap models) {
		return "getgroup";
	}
	
	@RequestMapping("/creategroup.html")
	public String creategroup() {
		return "creategroup";
	}
	
	@RequestMapping("/editgroup.html")
	public String editgroup()
	{
		return "editgroup";
	}
	
	@RequestMapping("/deletegroup.html")
	public String deletegroup() {
		
		return "deletegroup";
	}

}
