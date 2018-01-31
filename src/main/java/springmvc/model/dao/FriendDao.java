package springmvc.model.dao;

import java.util.List;

import springmvc.model.Friend;
import springmvc.model.User;

public interface FriendDao {
	
	Friend friendList(User user);
	void addFriend(Integer id,String email);
	void deleteFriend(Integer id);

}
