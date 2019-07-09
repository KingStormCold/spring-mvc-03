package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

	private static final long serialVersionUID = 3050640464816933435L;

	@Column
	private String name;

	@Column(unique = true)
	private String code;

	@OneToMany(mappedBy="category", fetch = FetchType.EAGER)
	private List<NewEntity> news;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<NewEntity> getNews() {
		return news;
	}

	public void setNews(List<NewEntity> news) {
		this.news = news;
	}
}
