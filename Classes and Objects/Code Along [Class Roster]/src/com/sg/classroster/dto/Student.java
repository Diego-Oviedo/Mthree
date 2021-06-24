package com.sg.classroster.dto;

public class Student {

	//variables
	private String firstName; 
	private String lastName;
	
	//default constructor
	public Student() {
		super();
	}

	//constructor with fields
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//getters
	public String getFirstName() {
		return firstName;
	}

	
	//setters 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	
	
	
}
