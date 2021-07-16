package com.MyCVOnline.model.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import com.MyCVOnline.model.*;

public interface ApplicantExperienceService {

	public void insertApplicantExperience(Applicant applicant,ApplicantExperience experience);

	public void deleteApplicantExperience(String applicantID, String experienceTitle);

	public void retreiveApplicantExperience(String applicantID, String experienceTitle);

	public ArrayList<ApplicantExperience> retreiveApplicantExperiencesByID(String applicantID);

	public void displayApplicantExperienceLogo(String applicantID, String experienceTitle,
			HttpServletResponse response);

	public void updateApplicantExperience(ApplicantExperience experience);

	public ArrayList<ApplicantExperience> retreiveApplicantExperiences();

}
