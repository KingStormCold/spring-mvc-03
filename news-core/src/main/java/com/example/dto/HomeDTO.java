package com.example.dto;

import java.io.Serializable;
import java.util.List;

public class HomeDTO implements Serializable {

	private static final long serialVersionUID = 1392922475638769474L;

	private List<NewDTO> topViews;
	private List<NewDTO> topNewDates;
	private List<CategoryDTO> categories;

	public List<NewDTO> getTopViews() {
		return topViews;
	}

	public void setTopViews(List<NewDTO> topViews) {
		this.topViews = topViews;
	}

	public List<NewDTO> getTopNewDates() {
		return topNewDates;
	}

	public void setTopNewDates(List<NewDTO> topNewDates) {
		this.topNewDates = topNewDates;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}
