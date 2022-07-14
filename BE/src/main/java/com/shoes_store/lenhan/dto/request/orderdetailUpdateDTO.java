package com.shoes_store.lenhan.dto.request;

public class orderdetailUpdateDTO {

	private Integer orderid;
	private Integer quantityid;
	private Integer Quantity;
	
	
	public orderdetailUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public orderdetailUpdateDTO(Integer orderid, Integer quantityid, Integer quantity) {
		super();
		this.orderid = orderid;
		this.quantityid = quantityid;
		Quantity = quantity;
	}


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public Integer getQuantityid() {
		return quantityid;
	}


	public void setQuantityid(Integer quantityid) {
		this.quantityid = quantityid;
	}


	public Integer getQuantity() {
		return Quantity;
	}


	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	
}
