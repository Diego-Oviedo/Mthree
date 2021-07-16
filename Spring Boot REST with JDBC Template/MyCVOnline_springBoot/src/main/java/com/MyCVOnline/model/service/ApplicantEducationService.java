package com.MyCVOnline.model.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import com.MyCVOnline.model.*;

public interface ApplicantEducationService {

	public void insertApplicantEducation(Applicant applicant,ApplicantEducation education);

	public void deleteApplicantEducation(String applicantID, String educationTitle);

	public ApplicantEducation retreiveApplicantEducation(String applicantID, String educationTitle);

	public ArrayList<ApplicantEducation> retreiveApplicantEducationsByID(String applicantID);

	public void displayApplicantEducationLogo(String applicantID, String educationTitle, HttpServletResponse response);

	public void updateApplicantEducation(ApplicantEducation education);

	public ArrayList<ApplicantEducation> retreiveApplicantEducations();
}
