package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.BlogComment;

public interface BlogCommentDao {
	void saveOrUpdate(BlogComment blogComment);

		BlogComment getById(String blogComment_id);
		
		List<BlogComment> listAllComments();
		
		void deleteBlogCommentById(String blogComment_id);
}
