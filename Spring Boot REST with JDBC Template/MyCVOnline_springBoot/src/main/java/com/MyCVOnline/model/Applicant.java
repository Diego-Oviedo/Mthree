package com.MyCVOnline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.MyCVOnline.model.validators.postalCodeCA;


@Entity
@Table(name = "APPLICANTS")
public class Applicant implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "APPLICANT_ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String applicantID;
	
	@NotEmpty
	@Size(min=5, max=15)
	@Column(name = "USERNAME")
	private String username;
	
	@NotEmpty
	@Size(min=8)
	@Column(name = "PASSWORD")
	private String password;
	
	@NotEmpty
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotEmpty
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "PROFESSION")
	private String profession;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@NotEmpty
	@Email
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	
	//@Pattern(regex="[A-Z0-9]{6}", message="Please introduce a valid  postal code and use Caps.")
	@postalCodeCA
	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PROVINCE")
	private String province;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ABOUT_YOU")
	private String aboutYou;
	
	
	//space trimmer for forms 
	@InitBinder
	 public void binder_container(WebDataBinder binder) {
		 
		 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
		 
		 binder.registerCustomEditor(String.class, space_trimmer);
		 
	 }
	
	

	@Lob
	@Column(name = "PROFILE_PICTURE", columnDefinition = "BLOB")
	private byte[] profilePicture;

	@OneToMany(mappedBy = "applicant", cascade = { CascadeType.ALL })
	private List<ApplicantEducation> educations;

	@OneToMany(mappedBy = "applicant", cascade = { CascadeType.ALL })
	private List<ApplicantExperience> experiences;

	@OneToMany(mappedBy = "applicant", cascade = { CascadeType.ALL })
	private List<ApplicantOtherSkill> otherSkills;

	@OneToMany(mappedBy = "applicant", cascade = { CascadeType.ALL })
	private List<ApplicantTechSkill> techSkills;

	@OneToMany(mappedBy = "applicant", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Application> applications;

	public Applicant() {
	}




	public String getApplicantID() {
		return applicantID;
	}




	public void setApplicantID(String applicantID) {
		this.applicantID = applicantID;
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




	public String getProfession() {
		return profession;
	}




	public void setProfession(String profession) {
		this.profession = profession;
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




	public String getStreetAddress() {
		return streetAddress;
	}




	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}




	public String getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
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




	public String getAboutYou() {
		return aboutYou;
	}




	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}




	public byte[] getProfilePicture() {
		return profilePicture;
	}




	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}




	public List<ApplicantEducation> getEducations() {
		return educations;
	}




	public void setEducations(List<ApplicantEducation> educations) {
		this.educations = educations;
	}




	public List<ApplicantExperience> getExperiences() {
		return experiences;
	}




	public void setExperiences(List<ApplicantExperience> experiences) {
		this.experiences = experiences;
	}




	public List<ApplicantOtherSkill> getOtherSkills() {
		return otherSkills;
	}




	public void setOtherSkills(List<ApplicantOtherSkill> otherSkills) {
		this.otherSkills = otherSkills;
	}




	public List<ApplicantTechSkill> getTechSkills() {
		return techSkills;
	}




	public void setTechSkills(List<ApplicantTechSkill> techSkills) {
		this.techSkills = techSkills;
	}




	public List<Application> getApplications() {
		return applications;
	}




	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public void setEducation(ApplicantEducation education) {

		if (educations == null) {

			educations = new ArrayList<ApplicantEducation>();

			education.setApplicant(this);

			educations.add(education);

		}
	}

	public void setExperience(ApplicantExperience experience) {

		if (experiences == null) {

			experiences = new ArrayList<ApplicantExperience>();

			experience.setApplicant(this);

			experiences.add(experience);
		}
	}

	public void setOtherSkill(ApplicantOtherSkill otherSkill) {

		if (otherSkills == null) {

			otherSkills = new ArrayList<ApplicantOtherSkill>();

			otherSkill.setApplicant(this);

			otherSkills.add(otherSkill);
		}
	}

	public void setTechSkill(ApplicantTechSkill techSkill) {

		if (techSkills == null) {

			techSkills = new ArrayList<ApplicantTechSkill>();

			techSkill.setApplicant(this);

			techSkills.add(techSkill);
		}
	}

	public void setApplication(Application application) {

		if (applications == null) {

			applications = new ArrayList<Application>();

			application.setApplicant(this);

			applications.add(application);
		}
	}
	

	@Override
	public String toString() {
		return "Applicant \napplicantID: " + applicantID + "\nusername: " + username + "\npassword: " + password
				+ "\nfirstName: " + firstName + "\nlastName: " + lastName + "\nprofession: " + profession
				+ "\nphoneNumber: " + phoneNumber + "\nemail: " + email + "\nstreetAddress: " + streetAddress
				+ "\npostalCode: " + postalCode + "\ncity: " + city + "\nprovince: " + province + "\ncountry: "
				+ country + "\naboutYou: " + aboutYou + "\neducations: " + educations + "\nexperiences: " + experiences
				+ "\notherSkills: " + otherSkills + "\ntechSkills: " + techSkills + "\napplications: " + applications
				+ "]";
	}

}
