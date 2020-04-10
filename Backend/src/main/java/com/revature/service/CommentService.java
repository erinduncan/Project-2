package com.revature.service;

import com.revature.dao.CommentDao;
import com.revature.model.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentDao cd;

	@Autowired
	public CommentService(CommentDao cd) {
        super();
        this.cd = cd;
    }

	// public List<Comment> getByAll() {
	// 	return cd.findAll();
	// }

	// public Comment getById(int id) {
	// 	return cd.findById(id);
	// }

	public Comment addComment(Comment u) {
		return cd.save(u);

	}

	public Comment updateComment(Comment u) {
		return cd.save(u);
	}


	// public Comment deleteComment(int id) {
	// 	return cd.delete(id);
	// }
}
