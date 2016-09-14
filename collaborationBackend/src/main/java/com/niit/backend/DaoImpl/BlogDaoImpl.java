package com.niit.backend.DaoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;



@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {
	
	

	@Override
	public void saveOrUpdate(Blog blog) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void editBlog(Blog blog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Blog get(String blog_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog getBlogByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
