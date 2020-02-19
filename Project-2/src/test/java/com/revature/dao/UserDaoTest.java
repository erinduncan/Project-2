package com.revature.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Autowired
	private UserDao ud;
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testUserDao() {
		System.out.println("Testing init of UserDao");
		assertTrue(ud != null );
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testFindAll() {
		List<User> list = ud.findAll();
		System.out.println(list);
		assertTrue( list != null);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testFindById() {
		int idTest = 1;
		User u = ud.findById(idTest);
		System.out.println(u);
		assertTrue(u != null);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdate() {
		User u = new User(1, "testupdated@email.test", "passwordupd", "firstUpd", "lastUpd");
		User updated = ud.update(u);
		System.out.println(updated);
		assertTrue(updated.getEmail().equals(u.getEmail()));
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testInsert() {
		User u = new User("test34@gmail.test", "password", "testFist", "testLast");
		User retU  = ud.insert(u);
		System.out.println(retU);
		assertTrue(true);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteByEmail() {
		User delU = ud.deleteByEmail("test1@gmail.test");
		System.out.println(delU);
		assertTrue(delU != null);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testFindByEmail() {
		User u = ud.findByEmail("test2@gmail.test");
		System.out.println(u);
		assertTrue(u != null);
	}

}
