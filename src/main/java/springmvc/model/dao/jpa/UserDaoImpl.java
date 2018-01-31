package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Friend;
import springmvc.model.User;
import springmvc.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		return entityManager.createQuery("from User order by id", User.class).getResultList();
	}

	@Override
	public void deleteUser(Integer id) {

	}

	@Override
	@Transactional
	public User editUser(User user) {
		return null;
	}

	@Override
	@Transactional
	public User registerUser(User user) {
		System.out.println("I am here");
		return entityManager.merge(user);
	}

	@Override
	public List<User> getFriendList(User u) {
		User user = new User();
		user.setId(1);
		return entityManager.createQuery("from User where id = :id", User.class).setParameter("id", user.getId()).getResultList();
	
	}

}
