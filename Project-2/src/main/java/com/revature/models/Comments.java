package com.revature.models;

import javax.persistence.CascadeType;
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
@Table(name = "Comments")
public class Comments {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@Column
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "postId")
	private Post postId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User userId;

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(int commentId, String text, Post postId, User userId) {
		super();
		this.commentId = commentId;
		this.text = text;
		this.postId = postId;
		this.userId = userId;
	}
	
	public Comments(String text, Post postId, User userId) {
		super();
		this.text = text;
		this.postId = postId;
		this.userId = userId;
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

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", text=" + text + ", postId=" + postId + ", userId=" + userId
				+ "]";
	}
}
