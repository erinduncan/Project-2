package com.revature.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDaoTest {
	
	@Autowired
	private CommentDao cd;
	@Autowired
	private PostDao pd;
	

	@Test
	public void testCommentDao() {
		System.out.println("CommentDao initialized!");
		assertTrue(cd != null);
	}

	@Test
	public void testFindAll() {
		ArrayList<Comment> list = (ArrayList<Comment>) cd.findAll();
		list.forEach((comment) -> {
			System.out.println(comment);
		});
		assertTrue(list != null);
	}

	@Test
	public void testFindById() {
		Comment comm = cd.findById(3);
		System.out.println(comm);
		assertTrue(comm != null);
	}

	@Test
	public void testUpdate() {
		Comment commtoUp = cd.findById(1);
		commtoUp.setText("Kira Queen Bit za Dusto da");
		System.out.println(commtoUp);
		cd.update(commtoUp);
		
		
	}

	@Test
	public void testInsert() {
		
		Post post = pd.findById(1);
		User user = post.getUser();
		System.out.println(post+"\n"+user);
		Comment comm = new Comment("Yes Way Yoshkage!");
		comm.setUser(user);
		comm.setPost(post);
		System.out.println(comm);
		assertEquals(cd.insert(comm), comm);
	}

	@Test
	public void testDeleteById() {
		Comment comm = cd.deleteById(4);
		assertTrue(comm != null);
	}
	

}
