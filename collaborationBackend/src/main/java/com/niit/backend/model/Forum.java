package com.niit.backend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Component
public class Forum {

	
	@Id
	private String forum_id;
	private String title;
	private String description;
	private Date createdAt;
	private String userDetails_id;

	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "forum")
	@JsonManagedReference
	private Set<ForumPost> forumPost=new HashSet<>();
	public Set<ForumPost> getForumPost() {
		return forumPost;
	}
	
	
	public void setForumPost(Set<ForumPost> forumPost) {
		this.forumPost = forumPost;
	}
	
	public String getForum_id() {
		return forum_id;
	}
	
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Forum(){
		this.forum_id="FRM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
