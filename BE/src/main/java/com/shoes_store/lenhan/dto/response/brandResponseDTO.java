package com.shoes_store.lenhan.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class brandResponseDTO {
	private Integer id;
	@JsonProperty("brandname")
	private String brandname;
	public brandResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public brandResponseDTO(Integer id, String brandname) {
		super();
		this.id = id;
		this.brandname = brandname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
}
