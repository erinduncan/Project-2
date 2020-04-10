package com.revature.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.model.Post;

@Service
public class PostService {

	@Autowired
	private PostDao pd;
	
	public Iterable<Post> getAll() {
		return pd.findAll();
	}
	
	// public Post getById(int postId) {
	// 	return pd.findById(postId);
	// }
	
	public Post update(Post p) {
		return pd.save(p);
	}
	
	public Post insert(Post p) {
		return pd.save(p);
	}
	
	public void delete(Post p) {
		pd.delete(p);
	}


}
