package com.shoes_store.lenhan.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="quantity")
public class quantity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="productid")
	private product product;
	
	@ManyToOne
	@JoinColumn(name="sizeid")
	private size size;
	private Integer quantity;
	
	@OneToMany(mappedBy = "quantitys", fetch = FetchType.LAZY)
	private Set<cartdetail> cartdetails;
	
	@OneToMany(mappedBy = "quantitys", fetch = FetchType.LAZY)
	private Set<orderdetail> orderdetails;

	public quantity() {
		super();
	}


	public quantity(Integer id, com.shoes_store.lenhan.model.product product, com.shoes_store.lenhan.model.size size,
			Integer quantity,Set<cartdetail> cartdetails, Set<orderdetail> orderdetails) {
		super();
		this.id = id;
		this.product = product;
		this.size = size;
		this.quantity = quantity;
		this.cartdetails = cartdetails;
		this.orderdetails = orderdetails;
	}

	public quantity(Integer id, com.shoes_store.lenhan.model.product product, com.shoes_store.lenhan.model.size size,
			Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.size = size;
		this.quantity = quantity;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public product getProduct() {
		return product;
	}


	public void setProduct(product product) {
		this.product = product;
	}


	public size getSize() {
		return size;
	}


	public void setSize(size size) {
		this.size = size;
	}


}
