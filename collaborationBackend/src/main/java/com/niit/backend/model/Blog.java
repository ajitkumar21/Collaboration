package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Blog {
	@Id
private String blog_id;
private String title;
private String desscripti;
private String status;
private String userDetails_id;
private String noOfComment;
private String createdAt;


public String getBlog_id() {
	return blog_id;
}
public void setBlog_id(String blog_id) {
	this.blog_id = blog_id;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDesscripti() {
	return desscripti;
}
public void setDesscripti(String desscripti) {
	this.desscripti = desscripti;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUserDetails_id() {
	return userDetails_id;
}
public void setUserDetails_id(String userDetails_id) {
	this.userDetails_id = userDetails_id;
}
public String getNoOfComment() {
	return noOfComment;
}
public void setNoOfComment(String noOfComment) {
	this.noOfComment = noOfComment;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
private Blog(){
	this.blog_id="BLG"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

}
