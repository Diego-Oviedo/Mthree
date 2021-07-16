package com.MyCVOnline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Entity
@Table(name = "COMPANIES_POSITIONS")
public class CompanyPosition implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "POSITION_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String positionID;

	@NotEmpty
	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@NotEmpty
	@Column(name = "JOB_DESCRIPTION")
	private String jobDescription;

	@NotEmpty
	@Column(name = "JOB_DOMAIN")
	private String jobDomain;

	@NotEmpty
	@Column(name = "TYPE_OF_JOB")
	private String typeOfJob;

	@NotEmpty
	@Column(name = "AVAILABILITY")
	private String availability;

	@NotEmpty
	@Column(name = "OFFER_SALARY")
	private String offerSalary;

	@NotEmpty
	@Column(name = "ADDITIONAL_COMPENSATION")
	private String additionalCompensation;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	
	//space trimmer for forms 
	@InitBinder
	 public void binder_container(WebDataBinder binder) {
		 
		 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
		 
		 binder.registerCustomEditor(String.class, space_trimmer);
		 
	 }		

	@OneToMany(mappedBy = "position", cascade = { CascadeType.ALL })
	private List<CPositionExperience> experiences;

	@OneToMany(mappedBy = "position", cascade = { CascadeType.ALL })
	private List<CPositionQualification> qualifications;

	@OneToMany(mappedBy = "position", cascade = { CascadeType.ALL })
	private List<Application> applications;

	public CompanyPosition() {
		super();
	}

	public CompanyPosition(String positionID, String jobTitle, String jobDescription, String jobDomain,
			String typeOfJob, String availability, String offerSalary, String additionalCompensation, Company company,
			List<CPositionExperience> experiences, List<CPositionQualification> qualifications,
			List<Application> applications) {
		super();
		this.positionID = positionID;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobDomain = jobDomain;
		this.typeOfJob = typeOfJob;
		this.availability = availability;
		this.offerSalary = offerSalary;
		this.additionalCompensation = additionalCompensation;
		this.company = company;
		this.experiences = experiences;
		this.qualifications = qualifications;
		this.applications = applications;
	}

	public String getPositionID() {
		return positionID;
	}

	public void setPositionID(String positionID) {
		this.positionID = positionID;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobDomain() {
		return jobDomain;
	}

	public void setJobDomain(String jobDomain) {
		this.jobDomain = jobDomain;
	}

	public String getTypeOfJob() {
		return typeOfJob;
	}

	public void setTypeOfJob(String typeOfJob) {
		this.typeOfJob = typeOfJob;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getOfferSalary() {
		return offerSalary;
	}

	public void setOfferSalary(String offerSalary) {
		this.offerSalary = offerSalary;
	}

	public String getAdditionalCompensation() {
		return additionalCompensation;
	}

	public void setAdditionalCompensation(String additionalCompensation) {
		this.additionalCompensation = additionalCompensation;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<CPositionExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<CPositionExperience> experiences) {
		this.experiences = experiences;
	}

	public List<CPositionQualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<CPositionQualification> qualifications) {
		this.qualifications = qualifications;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public void addExperience(CPositionExperience experience) {

		if (experiences == null) {

			experiences = new ArrayList<CPositionExperience>();

			experience.setPosition(this);

			experiences.add(experience);
		}
	}

	public void addQualification(CPositionQualification qualification) {

		if (qualifications == null) {

			qualifications = new ArrayList<CPositionQualification>();

			qualification.setPosition(this);

			qualifications.add(qualification);
		}
	}

	@Override
	public String toString() {
		return "CompanyPosition [positionID=" + positionID + ", jobTitle=" + jobTitle + ", jobDescription="
				+ jobDescription + ", jobDomain=" + jobDomain + ", typeOfJob=" + typeOfJob + ", availability="
				+ availability + ", offerSalary=" + offerSalary + ", additionalCompensation=" + additionalCompensation
				+ ", company=" + company + ", experiences=" + experiences + ", qualifications=" + qualifications
				+ ", applications=" + applications + "]";
	}

}
