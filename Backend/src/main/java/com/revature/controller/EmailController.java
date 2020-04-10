package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.User;
import com.revature.service.EmailService;
import com.revature.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

	@Autowired
	EmailService es;

	@Autowired
	UserService us;

	@RequestMapping(method = RequestMethod.POST, value = "/email.app", consumes = "application/json")
	public @ResponseBody void sendEmail(@RequestBody User user) {
		String email = user.getEmail();
		if (us.getByEmail(email) != null) {
			String mail = email;

			es.sendEmail(mail);

		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/resetpassword.app", produces = "application/json")
	public ResponseEntity<User> resetPassword(@RequestBody User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		
		User u = us.getByEmail(email);
		if (u != null) {
			u.setPassword(password);
			us.updateUser(u);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
}
