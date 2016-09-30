package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Forum;

public interface ForumDao {
	
void saveOrUpdate(Forum forum);
	
	List<Forum> listAllForums();
	
	List<Forum> listSingleForum();
	
	public Forum findByName(String title);

		boolean isForumExist(Forum forum);

		Forum findById(String forum_id);

		void deleteForumById(String forum_id);

		void deleteAllForums();
		
		

}
