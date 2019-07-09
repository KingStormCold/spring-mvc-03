package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

	private static final long serialVersionUID = -938861969689215750L;

	@Column
	private String content;

	@Column
	private long parentId;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity users;

	@ManyToOne
	@JoinColumn(name = "new_id", nullable = false)
	private NewEntity news;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public NewEntity getNews() {
		return news;
	}

	public void setNews(NewEntity news) {
		this.news = news;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}


}
