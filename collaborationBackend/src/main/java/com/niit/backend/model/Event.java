package com.niit.backend.model;

import java.util.UUID;

public class Event {
	
private String event_id;
private String eventName;
private String createdAt;
private String description;


public String getEvent_id() {
	return event_id;
}
public void setEvent_id(String event_id) {
	this.event_id = event_id;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Event(){
	this.event_id="EVT"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}
