package com.medratech.model.impl;

import javax.persistence.Entity;

import com.medratech.model.Model;

@Entity
public class User extends Model {
	
	private static final long serialVersionUID = -450572622610037574L;
	
	private String username;
	private String realname;
	private String email;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
