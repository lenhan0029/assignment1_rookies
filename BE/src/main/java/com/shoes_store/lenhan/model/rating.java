package com.shoes_store.lenhan.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productid")
	private product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerid")
	private customer customer;
	private Integer starrating;
	private String comment;
	public rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public rating(Integer id, com.shoes_store.lenhan.model.product product,
			com.shoes_store.lenhan.model.customer customer, Integer starrating, String comment) {
		super();
		this.id = id;
		this.product = product;
		this.customer = customer;
		this.starrating = starrating;
		this.comment = comment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public customer getCustomer() {
		return customer;
	}
	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	public Integer getStarrating() {
		return starrating;
	}
	public void setStar_rating(Integer starrating) {
		this.starrating = starrating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "rating [id=" + id + ", product=" + product + ", customer=" + customer + ", starrating=" + starrating
				+ ", comment=" + comment + "]";
	}
	
}
