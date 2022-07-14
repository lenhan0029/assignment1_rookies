package com.shoes_store.lenhan.model;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	@OneToOne
	@JoinColumn(name="customerid", referencedColumnName = "id")
	private customer customer;
	
	@OneToOne(mappedBy = "account")
	private cart cart;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private Set<order> order;
	
	@ManyToOne
	@JoinColumn(name="roleid",referencedColumnName = "id")
	private role role;
	public account() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public account(Integer id, String username, String password, customer customer,
			role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.customer = customer;
		this.role = role;
	}


	
	public Integer getId() {
		return id;
	}
	public customer getCustomer() {
		return customer;
	}
	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	
	public role getRole() {
		return role;
	}


	public void setRole(role role) {
		this.role = role;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "account [id=" + id + ", username=" + username + ", password=" + password + "]";
	}



	
	
	
}
