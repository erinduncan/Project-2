package com.revature.models;

import java.sql.Blob;
import java.sql.Date;
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

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@Column(name = "postId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body", length = 1000)
	private String body;
	
	@Column(name = "submitted")
	private Date submitted;
	
	@Column(name = "image")
	private Blob image;
	
	@Column(name = "liked")
	private Boolean liked;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User userId;
	
	@OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Comments> commentId;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int postId, String title, String body, Date submitted, Blob image, Boolean liked, User userId,
			Set<Comments> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.body = body;
		this.submitted = submitted;
		this.image = image;
		this.liked = liked;
		this.userId = userId;
		this.commentId = comments;
	}
	public Post(String title, String body, Date submitted, Blob image, Boolean liked, User userId ) {
		super();
		this.title = title;
		this.body = body;
		this.submitted = submitted;
		this.image = image;
		this.liked = liked;
		this.userId = userId;
	}

	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", body=" + body + ", timestamp=" + submitted + ", like="
				+ liked + ", userId=" + userId + ", comments=" + commentId + "]";
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Set<Comments> getCommentId() {
		return commentId;
	}

	public void setCommentId(Set<Comments> commentId) {
		this.commentId = commentId;
	}
	
	
	

}