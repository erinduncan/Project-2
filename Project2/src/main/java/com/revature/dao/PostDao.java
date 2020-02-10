package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.models.Post;
import com.revature.util.HibernateUtil;

public class PostDao implements DaoContract<Post> {

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findById(int id) {
		// TODO Auto-generated method stub
		return null;
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
//		Log4j.log.info("New user has been created.");
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
