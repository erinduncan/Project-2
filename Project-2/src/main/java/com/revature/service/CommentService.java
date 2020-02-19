package com.revature.service;

import java.util.List;

import com.revature.dao.CommentDao;
import com.revature.models.Comment;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {
	
	@Autowired
	private CommentDao cd;
	
	public List<Comment> getAll(Comment p) {
		return cd.findAll();
	}
	
	public Comment update(Comment p) {
		return cd.update(p);
	}
	
	public Comment insert(Comment p) {
		return cd.insert(p);
	}

	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}

	public List<Comment> getByAll() {
		return cd.findAll();
	}

	public Comment getById(int id) {
		return cd.findById(id);
	}

	public Comment addComment(Comment u) {
		return cd.insert(u);

	}

	public Comment updateComment(Comment u) {
		return cd.update(u);
	}


	public Comment deleteComment(int id) {
		return cd.deleteById(id);
	}
}
