package com.niit.backend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Component
public class PostComment {
	@Id
	private String postComment_id;
	private String userDetails_id;
	private String description;
	private Date createdAt;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "forumPost_id" , nullable = false)
	@JsonBackReference
	private ForumPost forumPost;
	
	public ForumPost getForumPost() {
		return forumPost;
	}
	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}
	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
public String getPostComment_id() {
		return postComment_id;
	}
	public void setPostComment_id(String postComment_id) {
		this.postComment_id = postComment_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
public PostComment(){
	this.postComment_id="FPCID"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
