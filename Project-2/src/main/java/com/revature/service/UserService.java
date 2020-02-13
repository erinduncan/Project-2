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
	
	public List<User> getAll(){
		return ud.findAll();
	}
	
	public User getEmail(String email) {
		return ud.findByEmail(email);
	}
	
	public User getId(int id) {
		return ud.findById(id);
	}
	
	public void addUser(User u) {
		ud.insert(u);
	}
	

}
