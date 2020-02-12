package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Maresh
 * 
 * Configuration (class)
 * 		Configurations job is to gather information from hibernate.cfg.xml and use 
 * 		that information to create a session factory
 * 
 * SeesionFactory (Interface)
 * 		SeesionFactory's job is to create sessions and store information on how 
 * 		to make connections to your db. Once it is configured, it is immutable.
 * 
 * Session (interface)
 * 		Session manages the connection to your db and provides CRUD operations
 * 
 * Transaction (Interface)
 * 		Transaction manages your transactions and cache. Must be ACID.
 * 
 * ACID:
 * 		Atomicity: All or nothing. You cannot have part of a transaction
 * 		Consistency: After a transaction, the sate of the records will be consistent
 * 		Isolated: Each transaction run independently, they cannot interfere with each other
 * 		Durable: Data will persist
 *
 */

public class HibernateUtil {

	private static SessionFactory sf;
	
	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		return config.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		if(sf == null) {
			sf = buildSessionFactory();
		}
		return sf;
	}
	
//	Create DAOs
}
