package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CommentDao;
import com.revature.models.Comment;

@Service
public class CommentService {
	
	@Autowired
	private CommentDao cd;
	
	public List<Comment> getAll(Comment p) {
		return cd.findAll(p);
	}
	
	public Comment update(Comment p) {
		return cd.update(p);
	}
	
	public Comment insert(Comment p) {
		return cd.insert(p);
	}


}
