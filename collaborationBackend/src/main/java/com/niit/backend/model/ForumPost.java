package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
@Component
public class ForumPost {

	
@Id
private String forumPost_id;
private String userDetails_id;
private String forumDescription;
private String createdAt;


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
public ForumPost(){
	this.forumPost_id="FPID"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
