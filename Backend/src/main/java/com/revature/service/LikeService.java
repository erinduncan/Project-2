package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.LikeDao;
import com.revature.model.Like;

@Service
public class LikeService {

	private LikeDao ld;
	
	@Autowired
	public void setLd(LikeDao ld) {
		this.ld = ld;
	}
	
	public List<Like> readAll() {
		return ld.findAll();
	}
	
	public Like findById(int id) {
		return ld.findById(id);
	}
	
	public Like update(Like l) {
		return ld.update(l);
	}
	
	public Like insert(Like l) {
		return ld.insert(l);
	}
	
	public void delete(Like l) {
		ld.delete(l);
	}
}
