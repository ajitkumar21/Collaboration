package com.niit.backend.Dao;

import java.util.List;

import com.niit.backend.model.Blog;
import com.niit.backend.model.Event;

public interface BlogDao {
	void saveOrUpdate(Blog blog);

	void editBlog(Blog blog);
		
	Blog get(String blog_id);
		
		List<Blog> listAllBlog();
		
	
		
		public Blog findByTitle(String title);

			boolean isBlogExist(Blog blog);

			Blog findById(String blog_id);

			void deleteBlogById(String blog_id);

			void deleteAllBlogs();
		
	

}
