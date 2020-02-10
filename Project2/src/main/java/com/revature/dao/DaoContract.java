package com.revature.dao;

import java.util.List;

public interface DaoContract<T> {

	List<T> findAll();
	
	T findById(int id);
	
	T update (T t);
	
	T insert(T t);
	
	T delete(int id);
	
	T findByName(String name);
	
}
