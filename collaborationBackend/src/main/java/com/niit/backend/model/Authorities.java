package com.niit.backend.model;

import java.util.UUID;

public class Authorities {

	private String authorities_id;
	private String userName;
	private String authority;
	
	
	public String getAuthorities_id() {
		return authorities_id;
	}
	public void setAuthorities_id(String authorities_id) {
		this.authorities_id = authorities_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Authorities(){
		this.authorities_id="AUTH"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
