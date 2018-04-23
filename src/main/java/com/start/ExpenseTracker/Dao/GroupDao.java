package com.start.ExpenseTracker.Dao;

import java.util.List;

import com.start.ExpenseTracker.Model.Group;
import com.start.ExpenseTracker.Model.User;

public interface GroupDao {

	List<Group> getAllGroups(Integer id);

	Group getSingleGroupDetails(Integer id);

	void editGroup(User user, Group group);

	void deleteGroup(User user, Group group);

	Group addGroupMember(Group group);

}
