package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.revature.models.Comments;

@Repository
@Transactional
public class CommentDao {
	
	private SessionFactory sesf;

	public CommentDao(SessionFactory sesf) {
		super();
		this.sesf = sesf;
	}
	
	public List<Comments> findAll() {
		return sesf.getCurrentSession().createQuery("from comments", Comments.class).list();
	}
	
	public Comments findById(int id) {
		return sesf.getCurrentSession().get(Comments.class, id);
	}
	
	public Comments findByUserId(int userId) {
		return sesf.getCurrentSession().get(Comments.class, userId);
	}
	
	public void insert(Comments c) {
		sesf.getCurrentSession().save(c);
	}
	
	public void update(Comments c) {
		sesf.getCurrentSession().update(c);
	}
	
	public void delete(Comments c) {
		sesf.getCurrentSession().delete(c);
	}

}
