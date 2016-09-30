package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.PostComment;

public interface PostCommentDao {
	
	void saveOrUpdate(PostComment postComment);
	
	void deleteForumPostComment(PostComment postComment);
	
	PostComment getById(String postComment_id);
		
		List<PostComment> listAllPostComments();

}
