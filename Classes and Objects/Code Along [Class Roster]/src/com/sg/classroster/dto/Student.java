package com.sg.classroster.dto;
import java.util.*;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cohort == null) ? 0 : cohort.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (cohort == null) {
			if (other.cohort != null)
				return false;
		} else if (!cohort.equals(other.cohort))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentId=" + studentId + ", cohort="
				+ cohort + "]";
	}
	
	
}
