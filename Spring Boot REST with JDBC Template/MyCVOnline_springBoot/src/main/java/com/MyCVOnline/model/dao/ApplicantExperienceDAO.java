package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantExperience;

public interface ApplicantExperienceDAO {

	public void insertApplicantExperience(Applicant applicant,ApplicantExperience experience);

	public void deleteApplicantExperience(String applicantID, String experienceTitle);

	public ApplicantExperience retreiveApplicantExperience(String applicantID, String experienceTitle);

	public ArrayList<ApplicantExperience> retreiveApplicantExperiencesByID(String applicantID);

	public void displayApplicantExperienceLogo(String applicantID, String experienceTitle,
			HttpServletResponse response);

	public void updateApplicantExperience(ApplicantExperience experience);

	public ArrayList<ApplicantExperience> retreiveApplicantExperiences();

}
