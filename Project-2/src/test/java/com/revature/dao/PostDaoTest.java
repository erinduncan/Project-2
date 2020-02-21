package com.revature.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.model.Post;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PostDaoTest {
	
	@Autowired
	private PostDao pd;
	
	@Autowired
	private UserDao ud;

	@Test
	public void testPostDao() {
		assertTrue(pd != null);
	}
	@Test
	public void testFindAll() {
		List<Post> list = pd.findAll();
		System.out.println(list);
		assertTrue(list != null);
	}

	@Test
	public void testFindById() {
		int postid = 1;
		Post post = pd.findById(postid);
		System.out.println("Post: "+post);
		assertTrue(post != null);
	}


	@Test
	public void testInsert() {
		Post post = new Post(0,"testTitle", null,
				"My name is Yoshikage Kira. I'm 33 years old. "
				+ "My house is in the northeast section of Morioh, where all the villas are, and I am not married."
				+ " I work as an employee for the Kame Yu department stores, and I get home every day by 8 PM at the latest."
				+ " I don't smoke, but I occasionally drink. I'm in bed by 11 PM, and make sure I get eight hours of sleep, "
				+ "no matter what. After having a glass of warm milk and doing about twenty minutes of stretches before going"
				+ " to bed, I usually have no problems sleeping until morning. Just like a baby, I wake up without any fatigue"
				+ " or stress in the morning. I was told there were no issues at my last check-up. I'm trying to explain that"
				+ " I'm a person who wishes to live a very quiet life. I take care not to trouble myself with any enemies, "
				+ "like winning and losing, that would cause me to lose sleep at night. That is how I deal with society, and I "
				+ "know that is what brings me happiness. Although, if I were to fight I wouldn't lose to anyone."
				);
		post.setUser(ud.findById(1));
		Post retP = pd.insert(post);
		assertTrue(retP != null);
	}
	
	@Test
	public void testUpdate() {
		int id = 1;
		Post p = pd.findById(id);
		Post retp = pd.update(p);
		System.out.println(retp);
		assertTrue(retp != null);
		
	}

//	@Test
//	public void testDeleteById() {
//		Post p = pd.deleteById(1);
//		System.out.println(p);
//		assertTrue(p != null);
//	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

}
