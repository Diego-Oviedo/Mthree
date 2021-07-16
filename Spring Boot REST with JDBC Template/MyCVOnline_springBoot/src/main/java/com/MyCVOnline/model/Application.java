package com.MyCVOnline.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "APPLICATIONS")
public class Application  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "APPLICATION_NUMBER")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String applicationNumber;
	
	
	@DateTimeFormat(pattern = "DD/MM/YYYY")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	@Column(name = "APPLICATION_DATE", nullable = false)
	private String applicationDate;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "POSITION_ID")
	private CompanyPosition position;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;

	public Application() {
		super();
	}

	public Application(String applicationNumber, String applicationDate, CompanyPosition position,
			Applicant applicant) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicationDate = applicationDate;
		this.position = position;
		this.applicant = applicant;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public CompanyPosition getPosition() {
		return position;
	}

	public void setPosition(CompanyPosition position) {
		this.position = position;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Application [applicationNumber=" + applicationNumber + ", applicationDate=" + applicationDate
				+ ", position=" + position + ", applicant=" + applicant + "]";
	}

}
