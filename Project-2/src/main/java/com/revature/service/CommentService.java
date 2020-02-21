package com.revature.service;

import java.util.List;

import com.revature.dao.CommentDao;
import com.revature.model.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentDao cd;

	@Autowired
	public void setDao(CommentDao cd) {
		this.cd = cd;
	}

	public List<Comment> getByAll(Comment c) {
		return cd.findAll(c);
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
