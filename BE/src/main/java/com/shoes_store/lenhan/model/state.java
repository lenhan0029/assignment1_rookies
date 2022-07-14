package com.shoes_store.lenhan.model;

import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class state {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String state;
	@OneToMany(mappedBy = "state")
	private Set<order> order;
	public state() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public state(Integer id, String state,Set<order> order) {
		super();
		this.id = id;
		this.state = state;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "state [id=" + id + ", state=" + state + "]";
	}
	
	
}
