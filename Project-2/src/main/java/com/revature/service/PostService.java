package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.models.Post;

@Service
public class PostService {

	@Autowired
	private PostDao pd;
	
	public List<Post> getAll() {
		return pd.findAll();
	}
	
	public Post getById(int postId) {
		return pd.findById(postId);
	}
	
	public Post update(Post p) {
		return pd.update(p);
	}
	
	public Post addPost(Post p) {
		return pd.insert(p);
	}
	
	public Post deletePost(Post p) {
		return pd.delete(p);
	}


}
