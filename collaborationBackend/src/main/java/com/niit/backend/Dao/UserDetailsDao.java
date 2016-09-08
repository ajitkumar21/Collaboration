package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.UserDetails;

public interface UserDetailsDao {

	
   void saveOrUpdate(UserDetails userDetails);
	
	UserDetails get(String userDetails_id);
	
	UserDetails getUserDetailsByUserName(String userName);
	
	List<UserDetails> list();
	
	
}
