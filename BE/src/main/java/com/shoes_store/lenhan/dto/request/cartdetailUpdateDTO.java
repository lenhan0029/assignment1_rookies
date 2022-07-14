package com.shoes_store.lenhan.dto.request;

public class cartdetailUpdateDTO {

	private Integer cartid;
	private Integer quantityid;
	private Integer quantity;
	public cartdetailUpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cartdetailUpdateDTO(Integer cartid, Integer quantityid, Integer quantity) {
		super();
		this.cartid = cartid;
		this.quantityid = quantityid;
		this.quantity = quantity;
	}
	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
	public Integer getQuantityid() {
		return quantityid;
	}
	public void setQuantityid(Integer quantityid) {
		this.quantityid = quantityid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
