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
@Table(name = "C_POSITIONS_EXPERIENCES")
public class CPositionExperience implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column(name = "EXPERIENCE_NAME")
	private String experienceName;

	@NotEmpty
	@Column(name = "EXPERIENCE_YEARS")
	private String desiredYears;

	@NotEmpty
	@Column(name = "EXPERIENCE_DESCRIPTION")
	private String experienceDescription;
	
	//space trimmer for forms 
	@InitBinder
	 public void binder_container(WebDataBinder binder) {
		 
		 StringTrimmerEditor space_trimmer = new StringTrimmerEditor(true);
		 
		 binder.registerCustomEditor(String.class, space_trimmer);
		 
	 }		
	
	@Id
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "POSITION_ID")
	private CompanyPosition position;

	public CPositionExperience() {
		super();

	}

	public CPositionExperience(CompanyPosition position, String experienceName, String desiredYears,
			String experienceDescription) {
		super();
		this.position = position;
		this.experienceName = experienceName;
		this.desiredYears = desiredYears;
		this.experienceDescription = experienceDescription;
	}

	public CompanyPosition getPosition() {
		return position;
	}

	public String getExperienceName() {
		return experienceName;
	}

	public String getDesiredYears() {
		return desiredYears;
	}

	public String getExperienceDescription() {
		return experienceDescription;
	}

	public void setPosition(CompanyPosition position) {
		this.position = position;
	}

	public void setExperienceName(String experienceName) {
		this.experienceName = experienceName;
	}

	public void setDesiredYears(String desiredYears) {
		this.desiredYears = desiredYears;
	}

	public void setExperienceDescription(String experienceDescription) {
		this.experienceDescription = experienceDescription;
	}

	@Override
	public String toString() {
		return "CPositionExperience [position=" + position + ", experienceName=" + experienceName + ", desiredYears="
				+ desiredYears + ", experienceDescription=" + experienceDescription + "]";
	}

}
