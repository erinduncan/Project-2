package com.revature.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.Post;
import com.revature.service.PostService;
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	
	@Autowired
	private PostService us;
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/postlist.app", produces = "application/json")
	public ResponseEntity<List<Post>> getAllPostAsList() {
		return new ResponseEntity<>(us.getAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post{id}.app", produces = "application/json")
	public ResponseEntity<Post> findPostById(@PathVariable("id") int id) {
		return new ResponseEntity<>(us.getById(id), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updatepost.app", produces = "application/json")
	public ResponseEntity<Post> updatePost(@RequestBody Post p) {
		return new ResponseEntity<>(us.update(p), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/newpost.app", produces = "application/json")
	public ResponseEntity<Post> insertNewPost(@RequestBody Post p) {
		return new ResponseEntity<>(us.insert(p), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletepost.app", produces = "application/json")
	public ResponseEntity<Post> deletePost(@RequestBody Post p) {
		us.delete(p);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}