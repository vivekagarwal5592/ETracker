package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springmvc.model.Group;
import springmvc.model.User;
import springmvc.model.dao.GroupDao;


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
	public void editGroup(Integer id) {

	}

	@Override
	public void addGroup(Integer id) {

	}

	@Override
	public void deleteGroup(Integer id) {

	}

}
