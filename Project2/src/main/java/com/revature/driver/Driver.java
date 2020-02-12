package com.revature.driver;

import com.revature.dao.PostDao;
import com.revature.dao.UserDao;
import com.revature.models.Post;
import com.revature.models.User;

public class Driver {
	
	static UserDao ud = new UserDao();
	static PostDao pd = new PostDao();

	public static void main(String[] args) {
		ud.insert(new User(0, "erinerin@erin.com", "coolgirl93", "Erin", "Duncan"));
		pd.insert(new Post(0, "The Best Little Dog in the World", "This dog is fabulous, who would have thought!", null, null, null, null, null));
	}
		
}
