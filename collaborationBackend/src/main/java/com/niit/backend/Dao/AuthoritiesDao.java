package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Authorities;

public interface AuthoritiesDao {
	
	
	void saveOrUpdate(Authorities authorities);

	void editAuthorities(Authorities authorities);
		
	Authorities get(String authorities_id);
		
	List<Authorities> list();

}
