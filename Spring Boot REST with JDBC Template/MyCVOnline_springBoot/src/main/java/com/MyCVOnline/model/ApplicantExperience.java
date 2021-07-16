package com.MyCVOnline.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


@Entity
@Table(name = "APPLICANTS_EXPERIENCES")
public class ApplicantExperience implements Serializable{


	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "EXPERIENCE_TITLE")
	private String experienceTitle;

	@NotEmpty
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;

	@NotEmpty
	@Column(name = "DESCRIPTION")
	private String description;

	@Lob
	@Column(name = "EXP_LOGO", columnDefinition = "BLOB")
	private byte[] expLogo;
	
	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;
	
	
	//space trimmer for forms 
		@InitBinder
		 public void binder_container(WebDataBinder binder) {
			 
			 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
			 
			 binder.registerCustomEditor(String.class, space_trimmer);
			 
		 }

	public ApplicantExperience() {
		super();
	}

	public ApplicantExperience(String experienceTitle, String companyName,
			 LocalDateTime startDate, LocalDateTime endDate, String description, byte[] expLogo,
			Applicant applicant) {
		super();
		this.experienceTitle = experienceTitle;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.expLogo = expLogo;
		this.applicant = applicant;
	}

	public String getExperienceTitle() {
		return experienceTitle;
	}

	public void setExperienceTitle(String experienceTitle) {
		this.experienceTitle = experienceTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getExpLogo() {
		return expLogo;
	}

	public void setExpLogo(byte[] expLogo) {
		this.expLogo = expLogo;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	@Override
	public String toString() {
		return "ApplicantExperience [experienceTitle=" + experienceTitle + ", companyName=" + companyName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", description=" + description + ", expLogo="
				+ Arrays.toString(expLogo) + ", applicant=" + applicant + "]";
	}

	
	

	

}
