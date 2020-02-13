package com.revature.dao;

import java.util.List;

public interface DaoUserContract<T> {

	List<T> findAll();
	
	T findById(int id);
	
	T update (T t);
	
	T insert(T t);
	
	T delete(T t);
	
	T findByEmail(String email);
	
}
