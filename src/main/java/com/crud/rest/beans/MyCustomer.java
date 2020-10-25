package com.crud.rest.beans;

// MODEL CLASS

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mycustomer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp
public class MyCustomer {

	@Id
	@GeneratedValue
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private int age;

	@Column
	private String email;

	@Column
	private String city;

	//setters and getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//constructor with fields
	public MyCustomer(long id, String name, int age, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.city = city;
	}
   // constructor without fields
	public MyCustomer() {
		super();
	}

}
