package com.shoes_store.lenhan.model;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.Column;
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
import javax.persistence.Transient;

@Entity
@Table(name="orders")
public class order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(insertable = false, updatable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="customerid",referencedColumnName = "id")
	private account account;
	
	private Date ordereddate;
	private Date handleddate;
	
	@ManyToOne
	@JoinColumn(name="stateid",referencedColumnName = "id")
	private state state;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private Collection<orderdetail> orderdetails;
	public order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public order(Integer id, account account, Date ordereddate, Date handleddate,
		state state) {
		super();
		this.id = id;
		this.account = account;
		this.ordereddate = ordereddate;
		this.handleddate = handleddate;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public account getCustomer() {
		return account;
	}

	public void setCustomer(account optional) {
		this.account = optional;
	}

	public Date getOrdereddate() {
		return ordereddate;
	}

	public void setOrdereddate(Date ordereddate) {
		this.ordereddate = ordereddate;
	}

	public Date getHandleddate() {
		return handleddate;
	}

	public void setHandleddate(Date handleddate) {
		this.handleddate = handleddate;
	}

	public state getState() {
		return state;
	}

	public void setState(state state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", customer=" + account + ", ordereddate="
				+ ordereddate + ", handleddate=" + handleddate + ", state=" + state + "]";
	}
	
	
}
