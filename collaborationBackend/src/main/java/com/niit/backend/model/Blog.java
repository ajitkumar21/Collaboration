package com.niit.backend.model;

import java.io.Serializable;
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
public class Blog implements Serializable{
	
	
	
private static final long serialVersionUID = 1L;
	@Id
private String blog_id;
private String title;
private String description;
private String status;
private String userDetails_id;
private String noOfComment;
private Date createdAt;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "blog")
@JsonManagedReference
private Set<BlogComment> blog_comments = new HashSet<>();

public Set<BlogComment> getBlog_comments() {
	return blog_comments;
}

public void setBlog_comments(Set<BlogComment> blog_comments) {
	this.blog_comments = blog_comments;
}


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
public String getDescriptiion() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
private Blog(){
	this.blog_id="BLG"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

public Blog(String blog_id, String title, String description, String status, String userDetails_id, Date createdAt,
		Set<BlogComment> blog_comments) {
	super();
	this.blog_id = blog_id;
	this.title = title;
	this.description = description;
	this.status = status;
	this.userDetails_id = userDetails_id;
	this.createdAt = createdAt;
	this.blog_comments = blog_comments;
}

}
