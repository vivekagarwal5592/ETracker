package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springmvc.model.Friend;
import springmvc.model.User;
import springmvc.model.dao.FriendDao;

@Repository
public class FriendDaoImpl implements FriendDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Friend friendList(User u) {

		return null;
	}

	@Override
	public void addFriend(Integer id, String email) {
		User user = entityManager.createQuery("from User order by id", User.class).setParameter("email", email)
				.getSingleResult();
	}

	@Override
	public void deleteFriend(Integer id) {}

}
