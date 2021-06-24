package com.sg.classroster.dto;

public class Student {

	//variables
	private String firstName; 
	private String lastName;
	private String studentId;//read-only
	private String cohort;

	//constructor with fields
	public Student(String studentId) {
        this.studentId = studentId;
    }

	//getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getStudentId() {//read-only 
        return studentId;
    }
	
	public String getLastName() {
		return lastName;
	}
	
	public String getCohort() {
        return cohort;
    }

	
	//setters 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setCohort(String cohort) {
        this.cohort = cohort;
    }   


	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 
	
	
	
}
