package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.driver.Log;
import com.revature.models.Post;
import com.revature.util.HibernateUtil;

public class PostDao implements DaoContract<Post> {

	@Override
	public List<Post> findAll() {
		List<Post> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from posts", Post.class).list();
		Log.log.info("All posts found and returned.");
		return list;
	}

	@Override
	public Post findById(int id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sess.beginTransaction();
		Post post = sess.get(Post.class, id);
		tx.commit();
		Log.log.info("Post found by ID number.");
		return post;
	}

	@Override
	public Post update(Post t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post insert(Post t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		Log.log.info("New post created.");
		return t;
	}

	@Override
	public Post delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
