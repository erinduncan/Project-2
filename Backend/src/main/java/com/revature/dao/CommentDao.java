package com.revature.dao;

import com.revature.model.Comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommentDao extends CrudRepository<Comment, Integer> {

// 	// @Autowired
// 	private SessionFactory sesf;
	
// 	// @Autowired
// 	public CommentDao(SessionFactory sesf) {
// 		super();
// 		this.sesf = sesf;
// 	}
	

// //	@Override
// 	public List<Comment> findAll() {
// 		List<Comment> list;
// 		try {
// 			list = sesf.getCurrentSession().createQuery("from Comment", Comment.class).list();
// 			Log.log.info("All Comments found and returned.");
// 			return list;
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 			Log.log.error(e);
// 			e.printStackTrace();
// 			System.out.println("ERROR! Could not findAll");
// 		}
// 		return null;
// 	}

// //	@Override
// 	public Comment findById(int id) {
// 		Comment Comment;
// 		try {
// 			Comment = sesf.getCurrentSession().get(Comment.class, id);
// 			Log.log.info("Comment found by ID number.");
// 			return Comment;
// 		} catch (HibernateException e) {
// 			Log.log.error(e);
// 			e.printStackTrace();
// 			System.out.println("ERROR! Could not findbyid "+id);
// 		}
// 		return null;
// 	}

// //	@Override
// 	public Comment update(Comment t) {
// 		try {
// 			sesf.getCurrentSession().update(t);
// 			return t;
// 		} catch (HibernateException e) {
// 			Log.log.error(e);
// 			e.printStackTrace();
// 			System.out.println("ERROR! Could not update \n"+t.toString());
// 		}
// 		return null;
// 	}

// //	@Override
// 	public Comment insert(Comment t) {
// 		try {
// //			sesf.getCurrentSession().flush();
// 			sesf.getCurrentSession().save(t);
// 			Log.log.info("New Comment created.");
// 			return t;
// 		} catch (HibernateException e) {
// 			Log.log.error(e);
// 			e.printStackTrace();
// 			System.out.println("ERROR! Could not save \n"+t.toString());
// 		}
// 		return null;
// 	}


// 	public Comment deleteById(int id) {
// 		try {
// 			Comment com = sesf.getCurrentSession().get(Comment.class, id);
// 			sesf.getCurrentSession().delete(com);
// 			return com;
// 		} catch (HibernateException e) {
// 			Log.log.error(e);
// 			System.out.println("ERROR! Could not Deleteid not found "+id);
// 		}
// 		return null;
// 	}
	
//No! - for now
//	public ArrayList findByEmail(String email) {
//		try {
//			@SuppressWarnings("deprecation")
//			Criteria criteria = sesf.getCurrentSession().createCriteria(Comment.class);
//			criteria.add(Restrictions.like("email", email));
//			return (ArrayList) criteria.list();
//		} catch (HibernateException e) {
//			Log.log.error(e);
//			e.printStackTrace();
//			System.out.println("ERROR! Could not findbyemail "+email);
//		}
//		return null;
//	}
	
}
