package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.driver.Log;
import com.revature.model.Comment;
import com.revature.model.User;

@Repository
@Transactional
public class UserDao {

	private SessionFactory sesf;
	
	@Autowired
	public UserDao(SessionFactory sesf) {
		super();
		this.sesf = sesf;
	}
	

	public List<User> findAll() {
		List<User> list;
		try {
			list = sesf.getCurrentSession().createQuery("from User", User.class).list();
			Log.log.info("All users found and returned.");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			Log.log.error(e);
			System.out.println("ERROR! Could not findAll");
		}
		return null;
	}

	public User findById(int id) {
		User user;
		try {
			Session sess = sesf.getCurrentSession();
			user = sess.get(User.class, id);
			Log.log.info("User found by ID number.");
			return user;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not findbyid "+id);
		}
		return null;
	}

	public User update(User t) {
		try {
			sesf.getCurrentSession().update(t);
			return t;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not update \n"+t.toString());
		}
		return null;
	}

	public User insert(User t) {
//		try {
			sesf.getCurrentSession().save(t);
//			Log.log.info("New user created.");
			return t;
//		} catch (HibernateException e) {
//			Log.log.error(e);
//			System.out.println("ERROR! Could not save \n"+t.toString());
//		}
//		return null;
	}

	public User deleteByEmail(String email) {
		try {
			User t = findByEmail(email);
			sesf.getCurrentSession().delete(t);
			return t;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not Deletebyemail "+email);
		}
		return null;
	}

	public User findByEmail(String email) {
		return sesf.getCurrentSession().createQuery("from User where email = '" + email + "'", User.class).list().get(0);
	}
	
	public User delete(User p) {
		try {
			sesf.getCurrentSession().delete(p);
			return p;
		} catch (HibernateException e) {
			Log.log.error(e);
			System.out.println("ERROR! Could not Delete, id: "+p.getUserId()+" not found.");
		}
		return null;
	}

}
