package com.shoes_store.lenhan.dto.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class orderUpdateDTO {

	private Integer customerid;
//	private Date createddate;
//	private Date updateddate;
	private Integer stateid;
	public orderUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public orderUpdateDTO(Integer customerid/*, Date createddate, Date updateddate*/, Integer stateid) {
		super();
		this.customerid = customerid;
//		this.createddate = createddate;
//		this.updateddate = updateddate;
		this.stateid = stateid;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
//	public Date getCreateddate() {
//		return createddate;
//	}
//	public void setCreateddate(Date createddate) {
//		this.createddate = createddate;
//	}
//	public Date getUpdateddate() {
//		return updateddate;
//	}
//	public void setUpdateddate(Date updateddate) {
//		this.updateddate = updateddate;
//	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	
	
}
