package com.hibernate.composite;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AuthorId implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
