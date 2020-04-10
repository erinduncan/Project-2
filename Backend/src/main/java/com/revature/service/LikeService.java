package com.revature.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.dao.LikeDao;
import com.revature.model.Like;

@Service
public class LikeService {

	private LikeDao ld;
	
	@Autowired
	public LikeService(LikeDao ld) {
		super();
		this.ld = ld;
	}
	
	public Iterable<Like> readAll() {
		return ld.findAll();
	}
	
	// public Like findById(int id) {
	// 	return ld.findById(id);
	// }
	
	public Like update(Like l) {
		return ld.save(l);
	}
	
	public Like insert(Like l) {
		return ld.save(l);
	}
	
	public void delete(Like l) {
		ld.delete(l);
	}
}
