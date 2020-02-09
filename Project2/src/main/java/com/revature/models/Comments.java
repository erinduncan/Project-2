package com.revature.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comments {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	@Column
	private int postId;
	@OneToMany(mappedBy = "comments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Post> commentList;
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comments(int postId, Set<Post> commentList) {
		super();
		this.postId = postId;
		this.commentList = commentList;
	}
	public Comments(int commentId, int postId, Set<Post> commentList) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.commentList = commentList;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Set<Post> getCommentList() {
		return commentList;
	}
	public void setCommentList(Set<Post> commentList) {
		this.commentList = commentList;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", postId=" + postId + ", commentList=" + commentList + "]";
	}
	
	
	

}
