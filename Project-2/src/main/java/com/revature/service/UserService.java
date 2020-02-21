package com.revature.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.model.User;

@Service
public class UserService {
	
	
	private UserDao ud;
	
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	public List<User> getByAll(){
		return ud.findAll();
	}
	
	public User getByEmail(String email) {
		return ud.findByEmail(email);
	}
	
	public User getById(int id) {
		return ud.findById(id);
	}
	
	public User insertUser(User u) {
		return ud.insert(u);
		
	}
	
	public User updateUser(User u) {
		return ud.update(u);
	}
	
	public boolean validateUser(String email, String password, User u) {
		String toHash = email + password + "erin";
        String hashText = "";
        try
        {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] messageDigest = md.digest(toHash.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            hashText = no.toString(16); 
            while (hashText.length() < 32) { 
                hashText = "0" + hashText; 
            }
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        if (u.getPassword().equals(hashText))
        {
            return true;
        }
        return false;
    }
	
	public User deleteUserByEmail(String email) {
		return ud.deleteByEmail(email);
	}

	public User delete(User user) {
		return ud.delete(user);
	}
	

}
