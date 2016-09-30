package com.niit.backend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Component
public class ForumPost {

	
	@Id
private String forumPost_id;
private String userDetails_id;
private String forumDescription;
private Date createdAt;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "forum_id" , nullable = false)
@JsonBackReference
private Forum forum;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "forumPost")
@JsonManagedReference
private Set<PostComment> postComment=new HashSet<>();


public Set<PostComment> getPostComment() {
	return postComment;
}
public void setPostComment(Set<PostComment> postComment) {
	this.postComment = postComment;
}
public Forum getForum() {
	return forum;
}
public void setForum(Forum forum) {
	this.forum = forum;
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
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public ForumPost(){
	this.forumPost_id="FPID"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
