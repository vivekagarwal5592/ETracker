package springmvc.model.dao;

import java.util.List;

import springmvc.model.Group;

public interface GroupDao {
	
	List<Group> getAllGroups(Integer id);
	Group getSingleGroupDetails(Integer id);
	void editGroup(Integer id);
	void addGroup(Integer id);
	void deleteGroup(Integer id);
	

}
