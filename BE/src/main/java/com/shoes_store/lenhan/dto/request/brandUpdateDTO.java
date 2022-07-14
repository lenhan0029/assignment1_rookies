package com.shoes_store.lenhan.dto.request;

import javax.validation.constraints.NotBlank;

public class brandUpdateDTO {
	@NotBlank(message = "Brand name is required")
	private String brandname;

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
}
