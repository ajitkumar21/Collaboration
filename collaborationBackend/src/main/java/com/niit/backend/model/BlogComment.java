package com.niit.backend.model;

import java.util.UUID;

public class BlogComment {
	
	private String blogComment_id;
	private String description;
	private String blog_id;
	private String userDetails_id;
	
	
	public String getBlogComment_id() {
		return blogComment_id;
	}
	public void setBlogComment_id(String blogComment_id) {
		this.blogComment_id = blogComment_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}
public BlogComment(){
	this.blogComment_id="BLCMT"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
