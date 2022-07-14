package com.shoes_store.lenhan.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="brands")
public class brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String brandname;
	
	
	public brand() {
		
	}
	public brand(String brandname) {
		this.brandname=brandname;
	}
	public brand(Integer id, String brandname) {
		this.id=id;
		this.brandname=brandname;
	}

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<product> products;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	@Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + brandname + '\'' +
                '}';
    }
}
