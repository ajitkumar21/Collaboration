package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.User;

public interface UserDao {
	
	void saveOrUpdate(User user);

	void editUsers(User user);
		
		User get(String user_id);
		
		User getUserByUserName(String userName);
		
		List<User> list();
		
		

}
