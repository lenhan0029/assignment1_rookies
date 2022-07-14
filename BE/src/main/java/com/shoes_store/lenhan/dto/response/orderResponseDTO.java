package com.shoes_store.lenhan.dto.response;

import java.sql.Date;

public class orderResponseDTO {

	private Integer id;
	private Integer categoryid;
	private Date createddate;
	private Date updateddate;
	private Integer stateid;
	public orderResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderResponseDTO(Integer id, Integer categoryid, Date createddate, Date updateddate,
			Integer stateid) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.stateid = stateid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
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
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	
}
