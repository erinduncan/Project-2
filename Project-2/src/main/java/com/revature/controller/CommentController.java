package com.revature.controller;

import java.util.List;

import com.revature.models.Comment;
import com.revature.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = {"http://localhost:8080"})
public class CommentController {
    

    private CommentService cs;

    @Autowired
    public void setService(CommentService cs) {
		this.cs = cs;
	}

	

    @RequestMapping(method = RequestMethod.GET, value = "/commentlist.app", produces = "application/json")
    public ResponseEntity<List<Comment>> getAllCommentAsList() {
        return new ResponseEntity<>(cs.getByAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatecomment.app", produces = "application/json")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment p) {
        return new ResponseEntity<>(cs.updateComment(p), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/newcomment.app", produces = "application/json")
    public ResponseEntity<Comment> insertNewComment(@RequestBody Comment p) {
        return new ResponseEntity<>(cs.addComment(p), HttpStatus.ACCEPTED);
    }
}
