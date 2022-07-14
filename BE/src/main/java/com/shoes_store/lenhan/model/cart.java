package com.shoes_store.lenhan.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carts")
public class cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name="accountid", referencedColumnName = "id")
	private account account;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private Set<cartdetail> cartdetail;
	

	public cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cart(Integer id, account account,
			Set<cartdetail> cartdetail) {
		super();
		this.id = id;
		this.account = account;
		this.cartdetail = cartdetail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public account getAccount() {
		return account;
	}

	public void setAccount(account account) {
		this.account = account;
	}

//	public Set<cartdetail> getCartdetail() {
//		return cartdetail;
//	}
//
//	public void setCartdetail(Set<cartdetail> cartdetail) {
//		this.cartdetail = cartdetail;
//	}

	
	
}
