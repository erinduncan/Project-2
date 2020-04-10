package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@Column(nullable = false, name = "text")
	private String text;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_post_id")
	private Post post;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_user_id")
	private User user;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, String text) {
		super();
		this.commentId = commentId;
		this.text = text;
	}
	
	public Comment(String text, Post post, User user) {
		super();
		this.text = text;
		this.post = post;
		this.user = user;
	}

	public Comment(String text) {
		super();
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", text=" + text + ", post=" + post + ", user=" + user + "]";
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
