package com.revature.models;

public class Post {

	private String title;
	private String body;
	private String timestamp;
	private String location;
	private boolean like;
	private int userId;

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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String title, String body, String timestamp, String location, boolean like, int userId) {
		super();
		this.title = title;
		this.body = body;
		this.timestamp = timestamp;
		this.location = location;
		this.like = like;
		this.userId = userId;
	}

}
