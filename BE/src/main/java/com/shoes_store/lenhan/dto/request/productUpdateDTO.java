package com.shoes_store.lenhan.dto.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class productUpdateDTO {
	@NotBlank(message = "product name is required")
	private String productname;
//	@NotBlank(message = "category id is required")
	private Integer categoryid;
//	@NotBlank(message = "Brand id is required")
	private Integer brandid;
//	@NotBlank(message = "Price is required")
	private Integer price;
	@NotBlank(message = "Image is required")
	private String image;
//	@NotBlank(message = "createddate is required")
	private Date createddate;
	private Date updateddate;
	private String description;
	public productUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public productUpdateDTO(String productname, Integer categoryid, Integer brandid, Integer price,
			String image, Date createddate, Date updateddate, String description) {
		super();
		this.productname = productname;
		this.categoryid = categoryid;
		this.brandid = brandid;
		this.price = price;
		this.image = image;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.description = description;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
