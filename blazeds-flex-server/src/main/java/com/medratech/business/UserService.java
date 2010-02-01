package com.medratech.business;

import java.util.List;

import com.medratech.model.impl.User;

public interface UserService {

	public abstract List<User> add(String username, String realname, String email, String password);
	public abstract List<User> get();
	public abstract List<User> del(User user);

}