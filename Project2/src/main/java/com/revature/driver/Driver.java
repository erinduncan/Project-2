package com.revature.driver;

import com.revature.dao.UserDao;
import com.revature.models.User;

public class Driver {
	
	static UserDao ud = new UserDao();

	public static void main(String[] args) {
		ud.insert(new User(0, "erinerin@erin.com", "coolgirl93", "Erin", "Duncan"));
	}
		
}
