package com.shoes_store.lenhan.dto.request;

import javax.validation.constraints.NotBlank;

public class categoryUpdateDTO {
	@NotBlank(message = "Category name is required")
	private String categoryname;

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	
}
