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
@Table(name = "APPLICANTS_OTHER_SKILLS")
public class ApplicantOtherSkill implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "APPLICANT_ID")
	private Applicant applicant;

	@Column(name = "SKILL_NAME")
	@NotEmpty
	private String skillName;

	//space trimmer for forms 
		@InitBinder
		 public void binder_container(WebDataBinder binder) {
			 
			 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
			 
			 binder.registerCustomEditor(String.class, space_trimmer);
			 
		 }
	
	
	public ApplicantOtherSkill() {
		super();
	}

	public ApplicantOtherSkill(Applicant applicant, String skillName) {
		super();
		this.applicant = applicant;
		this.skillName = skillName;
	}

	

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApplicantOtherSkill [applicant=" + applicant + ", skillName=" + skillName + "]";
	}

}
