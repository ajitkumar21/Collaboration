package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.UserDetails;

public interface UserDetailsDao {

	
    void saveOrUpdate(UserDetails userDetails);
	
	UserDetails get(String userDetails_id);
	
	List<UserDetails> list();
	
	UserDetails getUserDetailsByUserName(String userName);

	List<UserDetails> listAllUserDetails();

	boolean isUserDetailsExist(UserDetails userDetails);
	
	
}
