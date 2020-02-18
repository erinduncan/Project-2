package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.UserDao;
import com.revature.models.User;

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
	
	public void User(User u) {
		ud.insert(u);
		
	}
	
	public void authenticate() {
		
	}
	
	public void deleteUser() {
		
	}
	

}
