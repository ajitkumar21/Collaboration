/*
  package com.niit.backend.testCase;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Dao.BlogCommentDao;
import com.niit.backend.Dao.BlogDao;
import com.niit.backend.model.Blog;
import com.niit.backend.model.BlogComment;

public class BlogTest {
public static void main(String args[]){
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.backend");
	context.refresh();
	
	Blog blog=(Blog) context.getBean("blog");
	BlogDao blogDao=(BlogDao) context.getBean("blogDao");
	blog.setCreatedAt(new Date());
	blog.setDescription("this is my blog");
	blog.setStatus("approved");
	blog.setUserDetails_id("USR007");
	blog.setTitle("1st blog");
	blogDao.saveOrUpdate(blog);
	
	BlogComment blogComment=(BlogComment) context.getBean("blogComment");
	BlogCommentDao blogCommentDao=(BlogCommentDao) context.getBean("blogCommentDao");
	blogComment.setCom_createdAt(new Date());
	blogComment.setDescription("hiiiiiiiii");
	blogComment.setUserDetails_id("USR005");
	blogComment.setBlog(blog);
	blogCommentDao.saveOrUpdate(blogComment);
	
	BlogComment blogComment1=(BlogComment) context.getBean("blogComment");
	BlogCommentDao blogCommentDao1=(BlogCommentDao) context.getBean("blogCommentDao");
	blogComment1.setCom_createdAt(new Date());
	blogComment1.setDescription("great");
	blogComment1.setUserDetails_id("USR006");
	blogComment1.setBlog(blog);
	blogCommentDao1.saveOrUpdate(blogComment1);
	
}
}

*/
