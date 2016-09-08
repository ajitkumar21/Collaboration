package com.niit.backend.model;

import java.util.UUID;

public class ForumPostComment {
	
	private String forumPostComment_id;
	private String forumPost_id;
	private String userDetails_id;
	private String forumDescription;
	private String createdAt;
	
	
	public String getForumPostComment_id() {
		return forumPostComment_id;
	}
	public void setForumPostComment_id(String forumPostComment_id) {
		this.forumPostComment_id = forumPostComment_id;
	}
	public String getForumPost_id() {
		return forumPost_id;
	}
	public void setForumPost_id(String forumPost_id) {
		this.forumPost_id = forumPost_id;
	}
	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}
	public String getForumDescription() {
		return forumDescription;
	}
	public void setForumDescription(String forumDescription) {
		this.forumDescription = forumDescription;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
public ForumPostComment(){
	this.forumPostComment_id="FPCID"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
