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
@Table(name = "APPLICANTS_EDUCATION")
public class ApplicantEducation implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column(name = "EDUCATION_TITLE")
	private String educationTitle;
	
	@NotEmpty
	@Column(name = "SCHOOL_NAME")
	private String schoolName;
	

	@DateTimeFormat(pattern = "YYYY/MM/DD")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;

	@DateTimeFormat(pattern = "YYYY/MM/DD")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	
	@NotEmpty
	@Column(name = "DESCRIPTION")
	private String description;

	@Lob
	@Column(name = "EDU_LOGO", columnDefinition = "BLOB")
	private byte[] eduLogo;

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
	

	public ApplicantEducation() {
		super();

	}


	public ApplicantEducation(@NotEmpty String educationTitle, @NotEmpty String schoolName,
			@NotEmpty LocalDateTime startDate, LocalDateTime endDate, String description, byte[] eduLogo,
			Applicant applicant) {
		super();
		this.educationTitle = educationTitle;
		this.schoolName = schoolName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.eduLogo = eduLogo;
		this.applicant = applicant;
	}


	public String getEducationTitle() {
		return educationTitle;
	}


	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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


	public byte[] getEduLogo() {
		return eduLogo;
	}


	public void setEduLogo(byte[] eduLogo) {
		this.eduLogo = eduLogo;
	}


	public Applicant getApplicant() {
		return applicant;
	}


	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	@Override
	public String toString() {
		return "ApplicantEducation [educationTitle=" + educationTitle + ", schoolName=" + schoolName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", description=" + description + ", eduLogo="
				+ Arrays.toString(eduLogo) + ", applicant=" + applicant + "]";
	}



	
}
