package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.driver.Log;
import com.revature.models.Post;
import com.revature.models.User;

@Repository
@Transactional
public class PostDao {

	
	@Autowired
	private SessionFactory sesf;
	
	@Autowired
	public PostDao(SessionFactory sesf) {
		super();
		this.sesf = sesf;
	}

	public List<Post> findAll() {
		List<Post> list = sesf.getCurrentSession().createQuery("from Post", Post.class).list();
		Log.log.info("All posts found and returned.");
		return list;
	}

	public Post findById(int postId) {
		try {
			Post post = sesf.getCurrentSession().get(Post.class, postId);
			Log.log.info("Post found by ID number.");
			return post;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public Post update(Post t) {
		try {
			sesf.getCurrentSession().update(t);
			return t;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not update \n"+t.toString());
		}
		return null;
	}


	public Post insert(Post t) {
		try {
			sesf.getCurrentSession().save(t);
			Log.log.info("New post created.");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}


	public Post deleteById(int id) {
		try {
			Post p = sesf.getCurrentSession().get(Post.class, id);
			sesf.getCurrentSession().delete(p);
			return p;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not Deleteid not found "+id);
		}
		return null;
	}


	public List<Post> findByUserId(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
