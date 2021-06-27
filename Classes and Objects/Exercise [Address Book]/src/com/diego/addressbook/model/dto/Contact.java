package com.diego.addressbook.model.dto;

public class Contact {
	
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String province;
	private String postalCode;
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contact(String fullName) {
		this.lastName = fullName;
	}


	public Contact(String firstName, String lastName, String streetAddress, String province, String postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.province = province;
		this.postalCode = postalCode;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
