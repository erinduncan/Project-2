package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.User;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	private UserService us;
	
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/userlist.app", produces = "application/json")
	public ResponseEntity<Iterable<User>> getAllUsersAsList() {
		return new ResponseEntity<>(us.getByAll(), HttpStatus.ACCEPTED);
	}
	// @RequestMapping(method = RequestMethod.GET, value = "/user{id}.app", produces = "application/json")
	// public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
	// 	return new ResponseEntity<>(us.getById(id), HttpStatus.ACCEPTED);
	// }
	@RequestMapping(method = RequestMethod.PUT, value = "/updateuser.app", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<>(us.updateUser(user), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/newuser.app", produces = "application/json")
	public ResponseEntity<User> insertNewUser(@RequestBody User user) {
		return new ResponseEntity<>(us.insertUser(user), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser.app", produces = "application/json")
	public ResponseEntity<User> deleteUser(@RequestBody User user) {
		us.delete(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	// @RequestMapping(method = RequestMethod.GET, value = "/{email}.app", produces = "application/json")
	// public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email) {
	// 	return new ResponseEntity<>(us.getByEmail(email), HttpStatus.ACCEPTED);
	// }
	// @RequestMapping(method = RequestMethod.POST, value = "/login.app", produces = "application/json")
	// public ResponseEntity<User> login(@RequestBody User req) {
	// 	String email = req.getEmail();
	// 	String password = req.getPassword();
	// 	User u = us.getByEmail(email);
	// 	if (u != null) {
	// 		if (us.validateUser(email, password, u)) {
	// 			return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
	// 		} else {
	// 			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	// 		}
	// 	} else {
	// 		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	// 	}
	// }
}