package com.MyCVOnline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Entity
@Table(name = "COMPANIES_EMPLOYEES")
public class CompanyEmployee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column(name = "USERNAME")
	private String username;

	@NotEmpty
	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "FISRT_NAME")
	private String firstName;
	
	@NotEmpty
	@Column(name = "LAST_NAME")
	private String lastName;
	
	//space trimmer for forms 
	@InitBinder
	 public void binder_container(WebDataBinder binder) {
		 
		 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
		 
		 binder.registerCustomEditor(String.class, space_trimmer);
		 
	 }	
	
	
	@Id
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	public CompanyEmployee() {
		super();

	}

	
	public CompanyEmployee(@NotEmpty String username, @NotEmpty String password, @NotEmpty String firstName,
			@NotEmpty String lastName, Company company) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "CompanyEmployee [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", company=" + company + "]";
	}

	

}
