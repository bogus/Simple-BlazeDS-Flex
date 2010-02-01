package com.medratech.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medratech.dao.impl.UserDao;
import com.medratech.model.impl.User;

@Service("userService")
@RemotingDestination
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	public List<User> add(String username, String realname, String email, String password) {
		User user = new User();
		user.setUsername(username);
		user.setRealname(realname);
		user.setEmail(email);
		user.setPassword(password);
		userDao.persist(user);
		return userDao.findAll();
	}

	@Transactional
	public List<User> del(User user) {
		userDao.remove(userDao.findById(User.class, user.getId()));
		return userDao.findAll();
	}

	@Transactional
	public List<User> get() {
		return userDao.findAll();
	}
	
	

}
