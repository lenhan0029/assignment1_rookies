package com.shoes_store.lenhan.model;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="size")
public class size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer size;
	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
	private Collection<quantity> quantities;
	public size() {
		
	}
	
	public size(Integer size) {
		this.size=size;
	}
	
	public size(Integer id, Integer size) {
		this.id=id;
		this.size=size;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "size [id=" + id + ", size=" + size + "]";
	}
	
	
}
