package com.revature.dao;

import javax.transaction.Transactional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Like;

@Repository
@Transactional
public interface LikeDao extends CrudRepository<Like, Integer> {

	// private SessionFactory sesf;
	
	// @Autowired
	// public LikeDao(SessionFactory sesf) {
	// 	super();
	// 	this.sesf = sesf;
	// }
	
	// public List<Like> findAll() {
	// 	return sesf.getCurrentSession().createQuery("from Like", Like.class).list();
	// }

	// public Like findById(int id) {
	// 	return sesf.getCurrentSession().get(Like.class, id);
	// }

	// public Like update(Like l) {
	// 	sesf.getCurrentSession().update(l);
	// 	return l;
	// }

	// public Like insert(Like l) {
	// 	sesf.getCurrentSession().save(l);
	// 	return l;
	// }

	// public void delete(Like l) {
	// 	sesf.getCurrentSession().delete(l);
	// }
}
