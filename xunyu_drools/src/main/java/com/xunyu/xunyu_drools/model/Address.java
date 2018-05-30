package com.xunyu.xunyu_drools.model;


import java.io.Serializable;

/**
 * @author 13017
 */
public class Address implements Serializable{

	private static final long serialVersionUID = -1269737912517341469L;
	private String postcode;
	
	private String street;
	
	private String state;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
