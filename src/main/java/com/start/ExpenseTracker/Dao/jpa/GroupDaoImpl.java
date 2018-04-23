package com.start.ExpenseTracker.Dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.start.ExpenseTracker.Dao.GroupDao;
import com.start.ExpenseTracker.Model.Group;
import com.start.ExpenseTracker.Model.User;



@Repository
public class GroupDaoImpl implements GroupDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Group> getAllGroups(Integer id) {
		return entityManager.createQuery("from Group order by id", Group.class).getResultList();
	}

	@Override
	public Group getSingleGroupDetails(Integer id) {
		return entityManager.find(Group.class, id);
	}

	@Override
	public Group addGroupMember(Group group) {
		
		return entityManager.merge(group);
		
	}

	@Override
	public void editGroup(User user, Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup(User user, Group group) {
		// TODO Auto-generated method stub
		
	}



}
