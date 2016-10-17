package com.niit.backend.model;

public class ModelClass {
	private Forum forum;
	private String forumPost;
	private Blog blog;
	private String blog_comments;
	
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public String getBlog_comments() {
		return blog_comments;
	}
	public void setBlog_comments(String blog_comments) {
		this.blog_comments = blog_comments;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public String getForumPost() {
		return forumPost;
	}
	public void setForumPost(String forumPost) {
		this.forumPost = forumPost;
	}

}
