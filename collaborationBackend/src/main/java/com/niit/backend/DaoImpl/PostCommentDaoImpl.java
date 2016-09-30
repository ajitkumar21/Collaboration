package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.PostCommentDao;
import com.niit.backend.model.PostComment;

@Repository("postCommentDao")
@Transactional
public class PostCommentDaoImpl implements PostCommentDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(PostComment postComment) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(postComment);

	}

	@Override
	public void deleteForumPostComment(PostComment postComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public PostComment getById(String postComment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostComment> listAllPostComments() {
		// TODO Auto-generated method stub
		return null;
	}

}
