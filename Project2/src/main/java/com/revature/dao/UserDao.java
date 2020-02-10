package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.driver.Log;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDao implements DaoContract<User> {

	public UserDao() {
		HibernateUtil.getSessionFactory().openSession();
	}

	@Override
	public List<User> findAll() {
		List<User> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from users", User.class).list();
		Log.log.info("All users found and returned.");
		return list;
	}

	@Override
	public User findById(int id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sess.beginTransaction();
		User user = sess.get(User.class, id);
		tx.commit();
		Log.log.info("User found by ID number.");
		return user;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		Log.log.info("New user created.");
		return t;
	}

	@Override
	public User delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
