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

import com.revature.models.User;
import com.revature.service.UserService;
@Controller
public class UserController {
	
	private UserService us = new UserService();

	
	@RequestMapping(method = RequestMethod.GET, value = "/userlist.app", produces = "application/json")
	public ResponseEntity<List<User>> getAllUsersAsList() {
		return new ResponseEntity<>(us.getByAll(), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/user{id}.app", produces = "application/json")
	public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
		return new ResponseEntity<>(us.getById(id), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/updateuser.app", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<>(us.updateUser(user), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/newuser.app", produces = "application/json")
	public ResponseEntity<User> insertNewUser(@RequestBody User user) {
		return new ResponseEntity<>(us.addUser(user), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser.app", produces = "application/json")
	public ResponseEntity<User> deleteUser(@RequestBody User user) {
//		us.delete(user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{email}.app", produces = "application/json")
	public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(us.getByEmail(email), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/login.app", produces = "application/json")
	public ResponseEntity<User> login(@RequestBody User reqbod) {
		String email = reqbod.getEmail();
		String password = reqbod.getPassword();
		User u = us.getByEmail(email);
		if (u != null) {
			if (us.authenticateUser(email, password)) {
				return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}