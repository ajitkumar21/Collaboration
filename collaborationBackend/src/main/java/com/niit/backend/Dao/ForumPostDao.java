package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.ForumPost;

public interface ForumPostDao {
	
	void saveOrUpdate(ForumPost forumPost);

	void editForum(ForumPost forumPost);
		
	void deleteForum(ForumPost forumPost);
	
	ForumPost get(String forumPost_id);
		
		List<ForumPost> listAllForumPost();

		void deleteForumPostById(String forumPost_id);

		ForumPost findById(String forumPost_id);

}
