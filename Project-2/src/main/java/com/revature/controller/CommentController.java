package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Comment;
import com.revature.model.Post;
import com.revature.service.CommentService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@RequestMapping(method = RequestMethod.GET, value = "/commentlist.app", produces = "application/json")
	public ResponseEntity<List<Comment>> getAllCommentAsList(@RequestBody Comment c) {
		return new ResponseEntity<>(cs.getByAll(c), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updatecomment.app", produces = "application/json")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment c) {
        return new ResponseEntity<>(cs.updateComment(c), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/newcomment.app", produces = "application/json")
    public ResponseEntity<Comment> insertNewComment(@RequestBody Comment c) {
        return new ResponseEntity<>(cs.addComment(c), HttpStatus.ACCEPTED);
    }


}
