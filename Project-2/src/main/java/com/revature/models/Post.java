package com.revature.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import org.hibernate.validator.constraints.br.TituloEleitoral;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	@Column
	private String title;
	@Column(length = 1000)
	private String body;
	@Column
	@CreationTimestamp
	private Date submitted;
	@Column
	private Boolean liked;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false )
	private User user;
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Post(int postId, String title, String body, Date submitted, Boolean liked ) {
		super();
		this.postId = postId;
		this.title = title;
		this.body = body;
		this.submitted = submitted;
		this.liked = liked;
	}

	public Post(String title, String body, Boolean liked) {
		super();
		this.title = title;
		this.body = body;
		this.liked = liked;
	}

	
	

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", body=" + body + ", submitted=" + submitted
				+ ", liked=" + liked + ", user=" + user + "]";
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

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
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