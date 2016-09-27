package com.niit.backend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Job {

@Id
private String job_id;
private String title;
private String description;
private Date createdAt;


public String getJob_id() {
	return job_id;
}
public void setJob_id(String job_id) {
	this.job_id = job_id;
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
public Job(){
	this.job_id="JOB"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
