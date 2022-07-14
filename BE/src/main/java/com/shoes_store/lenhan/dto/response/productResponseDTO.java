package com.shoes_store.lenhan.dto.response;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class productResponseDTO {
	private Integer id;
	private String productname;
	private Integer categoryid;
	private Integer brandid;
	private Integer price;
	private String image;
	private Date createddate;
	private Date updateddate;
	private String description;
	public productResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public productResponseDTO(Integer id, String productname, Integer categoryid, Integer brandid, Integer price,
			String image, Date createddate, Date updateddate, String description) {
		super();
		this.id = id;
		this.productname = productname;
		this.categoryid = categoryid;
		this.brandid = brandid;
		this.price = price;
		this.image = image;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
