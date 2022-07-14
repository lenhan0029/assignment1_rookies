package com.shoes_store.lenhan.model;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String customername;
	private String email;
	private String phonenumber;
	private String address;
	private String gender;
	private Integer age;


	@OneToOne(mappedBy = "customer")
	private account account;
	
//	@OneToOne(mappedBy = "customer")
//	private cart cart;
//	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<rating> ratingss;
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public customer(Integer id, String customername, String email, String phonenumber, String address, String gender,
			Integer age) {
		super();
		this.id = id;
		this.customername = customername;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.gender = gender;
		this.age = age;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "customer [id=" + id + ", customername=" + customername + ", email=" + email + ", phonenumber="
				+ phonenumber + ", address=" + address + ", gender=" + gender + ", age=" + age + "]";
	}
}