package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.ForumPostComment;

public interface ForumPostDao {
	
	void saveOrUpdate(ForumPostComment forumPostComment);

	void editForum(ForumPostComment forumPostComment);
		
	void deleteForum(ForumPostComment forumPostComment);
	
	ForumPostComment get(String forumPostComment_id);
		
	List<ForumPostComment> list();

}
