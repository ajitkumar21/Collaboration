package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ForumPostDao;
import com.niit.backend.model.ForumPost;

@Repository("forumPostDao")
@Transactional
public class ForumPostDaoImpl implements ForumPostDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void saveOrUpdate(ForumPost forumPost) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(forumPost);

	}

	@Override
	public void editForum(ForumPost forumPost) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteForum(ForumPost forumPost) {
		// TODO Auto-generated method stub

	}

	@Override
	public ForumPost get(String forumPost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForumPost> listAllForumPost() {
		// TODO Auto-generated method stub
		String hql="from ForumPost";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPost> listForumPost=query.getResultList();
		return listForumPost;
	}

	@Override
	public void deleteForumPostById(String forumPost_id) {
		// TODO Auto-generated method stub
		
		String hql="Delete forumPost where forumPost_id="+"'"+forumPost_id+"'";
	   /*
		ForumPost forumPostDelete= new ForumPost();
		forumPostDelete.setForumPost_id(forumPost_id);
		*/
		sessionFactory.getCurrentSession().delete(hql);
		
	}

	@Override
	public ForumPost findById(String forumPost_id) {
		// TODO Auto-generated method stub
		String hql = "from ForumPost where forumPost_id=" + "'" + forumPost_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPost> listBlog= (List<ForumPost>) query.getResultList();
		if (listBlog!= null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}

}
