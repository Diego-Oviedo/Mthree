package com.MyCVOnline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Entity
@Table(name = "COMPANIES")
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMPANY_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String companyID;

	@NotEmpty
	@Column(name = "COMPANY_NAME")
	@Size(min=1, max=40)
	private String companyName;

	@NotEmpty
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@NotEmpty
	@Column(name = "EMAIL")
	private String email;

	@NotEmpty
	@Column(name = "CITY")
	private String city;

	@NotEmpty
	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@NotEmpty
	@Column(name = "PROVINCE")
	private String province;

	@NotEmpty
	@Column(name = "COUNTRY")
	private String country;

	//space trimmer for forms 
		@InitBinder
		 public void binder_container(WebDataBinder binder) {
			 
			 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
			 
			 binder.registerCustomEditor(String.class, space_trimmer);
			 
		 }	
	
	
	@Lob
	@Column(name = "COMPANY_LOGO", columnDefinition = "BLOB")
	private byte[] companyLogo;

	@OneToMany(mappedBy = "company", cascade = { CascadeType.ALL })
	private List<CompanyEmployee> employees;

	@OneToMany(mappedBy = "company", cascade = { CascadeType.ALL })
	private List<CompanyPosition> positions;

	public Company() {
		super();

	}

	public Company(String companyID, String companyName, String phoneNumber, String email, String city,
			String postalCode, String province, String country, byte[] companyLogo, List<CompanyEmployee> employees,
			List<CompanyPosition> positions) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.postalCode = postalCode;
		this.province = province;
		this.country = country;
		this.companyLogo = companyLogo;
		this.employees = employees;
		this.positions = positions;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public byte[] getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(byte[] companyLogo) {
		this.companyLogo = companyLogo;
	}

	public List<CompanyEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<CompanyEmployee> employees) {
		this.employees = employees;
	}

	public List<CompanyPosition> getPositions() {
		return positions;
	}

	public void setPositions(List<CompanyPosition> positions) {
		this.positions = positions;
	}

	public void addEmployee(CompanyEmployee employee) {

		if (employees == null) {

			employees = new ArrayList<CompanyEmployee>();

			employee.setCompany(this);

			employees.add(employee);
		}
	}

	public void addPosition(CompanyPosition position) {

		if (positions == null) {

			positions = new ArrayList<CompanyPosition>();

			position.setCompany(this);

			positions.add(position);
		}
	}

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", city=" + city + ", postalCode=" + postalCode + ", province=" + province
				+ ", country=" + country + ", companyLogo=" + Arrays.toString(companyLogo) + ", employees=" + employees
				+ ", positions=" + positions + "]";
	}

}
