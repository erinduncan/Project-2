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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "likes")
public class Like {
	
	@Id
	@Column(name = "like_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_post_id")
	@JsonIgnore
	private Post likePost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "like_user_id")
	@JsonIgnore
	private User likeUser;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public Post getLikePost() {
		return likePost;
	}

	public void setLikePost(Post likePost) {
		this.likePost = likePost;
	}

	public User getLikeUser() {
		return likeUser;
	}

	public void setLikeUser(User likeUser) {
		this.likeUser = likeUser;
	}

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int likeId, Post likePost, User likeUser) {
		super();
		this.likeId = likeId;
		this.likePost = likePost;
		this.likeUser = likeUser;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", likePost=" + likePost + ", likeUser=" + likeUser + "]";
	}

}
