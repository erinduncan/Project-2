package com.revature.dao;

import java.util.List;

import com.revature.driver.Log;
import com.revature.models.Post;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		try {
			List<Post> list = sesf.getCurrentSession().createQuery("from Post", Post.class).list();
			Log.log.info("All posts found and returned.");
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			e.printStackTrace();
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


	public Post delete(Post p) {
		try {
			sesf.getCurrentSession().delete(p);
			return p;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not Delete, id: "+p.getPostId()+" not found.");
		}
		return null;
	}


	public List<Post> findByUserId(String userid) {
		try {
			List<Post> list = sesf.getCurrentSession().createQuery("from Post where email="+userid, Post.class).list();
			Log.log.info("All posts found and returned.");
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
