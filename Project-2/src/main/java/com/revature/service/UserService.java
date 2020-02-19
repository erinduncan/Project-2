package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.models.User;

@Service
public class UserService {
	
	
	private UserDao ud;
	
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	public List<User> getByAll(){
		return ud.findAll();
	}
	
	public User getByEmail(String email) {
		return ud.findByEmail(email);
	}
	
	public User getById(int id) {
		return ud.findById(id);
	}
	
	public User insertUser(User u) {
		return ud.insert(u);
		
	}
	
	public User updateUser(User u) {
		return ud.update(u);
	}
	
	public boolean validateUser(String email, String password, User u) {
		return true;
	}
	
	public User deleteUserByEmail(String email) {
		return ud.deleteByEmail(email);
	}

	public User delete(User user) {
		return ud.delete(user);
	}
	

}
