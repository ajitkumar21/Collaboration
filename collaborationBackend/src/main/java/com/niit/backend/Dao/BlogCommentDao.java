package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.BlogComment;

public interface BlogCommentDao {

	
	void saveOrUpdate(BlogComment blogComment);

	void editBlogComment(BlogComment blogComment);
		
	BlogComment get(String user_id);
		
	List<BlogComment> list();
		
	BlogComment getBlogCommentByName(String userName);
}
