package com.revature.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDaoTest {
	
	@Autowired
	private CommentDao cd;
	@Autowired
	private PostDao pd;
	

	@Test
	@Transactional
	@Rollback(value = true)
	public void testCommentDao() {
		System.out.println("CommentDao initialized!");
		assertTrue(cd != null);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testFindAll() {
		ArrayList<Comment> list = (ArrayList<Comment>) cd.findAll();
		list.forEach((comment) -> {
			System.out.println(comment);
		});
		assertTrue(list != null);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testFindById() {
		Comment comm = cd.findById(1);
		System.out.println(comm);
		assertTrue(comm != null);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdate() {
		Comment commtoUp = cd.findById(1);
		commtoUp.setText("Kira Queen Bit za Dusto da");
		System.out.println(commtoUp);
		cd.update(commtoUp);
		
		
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testInsert() {
		
		Post post = pd.findById(2);
		User user = post.getUser();
		System.out.println(post+"\n"+user);
		Comment comm = new Comment("Yes Way Yoshkage!");
		comm.setUser(user);
		comm.setPost(post);
		System.out.println(comm);
		assertEquals(cd.insert(comm), comm);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteById() {
		Comment comm = cd.deleteById(1);
		assertTrue(comm != null);
	}
	

}
