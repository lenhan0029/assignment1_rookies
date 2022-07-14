package com.shoes_store.lenhan.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class categoryResponseDTO {
	private Integer id;
	@JsonProperty("categoryname")
	private String categoryname;
	public categoryResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public categoryResponseDTO(Integer id, String categoryname) {
		super();
		this.id = id;
		this.categoryname = categoryname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
}
