package com.shoes_store.lenhan.model;

import java.sql.Date;
import java.util.Collection;

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
@Table(name="products")
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String productname;
	private Integer price;
	private String image;
	private Date createddate;
	private Date updateddate;
	private String description;
	
	public product() {
	}

	
	public product(Integer id, String productname, Integer price, String image, Date createddate, Date updateddate,
			String description, com.shoes_store.lenhan.model.category category,
			com.shoes_store.lenhan.model.brand brand, Collection<rating> ratings, Collection<quantity> quantities) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.image = image;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.description = description;
		this.category = category;
		this.brand = brand;
		this.ratings = ratings;
		this.quantities = quantities;
	}


	@ManyToOne
	@JoinColumn(name="categoryid")
	private category category;

	@ManyToOne
	@JoinColumn(name="brandid")
	private brand brand;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<rating> ratings;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Collection<quantity> quantities;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProduct_name(String productname) {
		this.productname = productname;
	}

	public category getCategory() {
		return category;
	}


	public void setCategory(category category) {
		this.category = category;
	}


	public brand getBrand() {
		return brand;
	}


	public void setBrand(brand brand) {
		this.brand = brand;
	}


	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "product [id=" + id + ", productname=" + productname + ", price=" + price + ", image=" + image
				+ ", createddate=" + createddate + ", updateddate=" + updateddate + ", description=" + description
				+ "]";
	}
	
	
}
