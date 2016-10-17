package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public BlogComment getById(String blogComment_id) {
		// TODO Auto-generated method stub
		String hql = "from BlogComment where blogComment_id=" + "'" + blogComment_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogComment> listBlogComment = (List<BlogComment>) query.getResultList();
		if (listBlogComment  != null && !listBlogComment .isEmpty()) {
			return listBlogComment.get(0);
		}
		return null;
	}
	
	@Override
	public List<BlogComment> listAllComments() {
		// TODO Auto-generated method stub
		String hql="from BlogComment";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogComment> listBlogComment=query.getResultList();
		return listBlogComment;
	}

	@Override
	public void deleteBlogCommentById(String blogComment_id) {
		// TODO Auto-generated method stub
		BlogComment blogCommToDelete = new BlogComment();
		blogCommToDelete.setBlogComment_id(blogComment_id);
		sessionFactory.getCurrentSession().delete(blogCommToDelete);
		
	}

}
