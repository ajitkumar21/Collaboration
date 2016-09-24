package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.BlogCommentDao;
import com.niit.backend.model.BlogComment;
@Repository("blogCommentDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {
 
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(BlogComment blogComment) {
		// TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
	}

	@Override
	public void editBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub

	}

	@Override
	public BlogComment get(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogComment> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogComment getBlogCommentByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
