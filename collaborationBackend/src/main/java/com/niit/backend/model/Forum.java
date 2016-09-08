package com.niit.backend.model;

import java.util.UUID;

public class Forum {
	
private String forum_id;
private String title;
private String description;
private String createdAt;
private String noOfComment;


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
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public String getNoOfComment() {
	return noOfComment;
}
public void setNoOfComment(String noOfComment) {
	this.noOfComment = noOfComment;
}
public Forum(){
	this.forum_id="FRM"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
