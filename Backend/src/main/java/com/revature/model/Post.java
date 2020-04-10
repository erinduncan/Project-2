package com.revature.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name = "title")
	private String title;
	
	@Column(length = 1000, name = "body")
	private String body;
	
	@Column(name = "submitted")
	@CreationTimestamp
	private Date submitted;
	
	@Column(name = "image")
	private Blob image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Post(int postId, String title, Blob image, String body, Date submitted) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.body = body;
		this.submitted = submitted;
	}

	public Post(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}
	
	public Post(int postId, String title, Blob image, String body) {
		super();
		this.postId = postId;
		this.title = title;
		this.image = image;
		this.body = body;
	}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", body=" + body + ", submitted=" + submitted
				+ ", user=" + user + "]";
	}
	
	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}


	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addComment(Comment comm) {
		comments.add(comm);
		comm.setPost(this);
	}

	public void removeComment(Comment comm) {
		comments.remove(comm);
		comm.setPost(null);
	}

}