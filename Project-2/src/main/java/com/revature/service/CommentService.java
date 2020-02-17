package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.CommentDao;
import com.revature.models.Comments;

@Service
public class CommentService {

	private CommentDao cd;
	
	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}
	
	public List<Comments> findAll() {
		return cd.findAll();
	}
	
	public Comments findById(int id) {
		return cd.findById(id);
	}
	
	public void update(Comments c) {
		cd.update(c);
	}
	
	public void insert(Comments c) {
		cd.insert(c);
	}
	
	public void delete(Comments c) {
		cd.delete(c);
	}
}
