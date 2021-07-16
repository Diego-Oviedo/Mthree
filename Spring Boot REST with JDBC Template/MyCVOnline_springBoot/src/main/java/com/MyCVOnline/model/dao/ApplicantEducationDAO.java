package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantEducation;

public interface ApplicantEducationDAO {

	public void insertApplicantEducation(Applicant applicant,ApplicantEducation education);

	public void deleteApplicantEducation(String applicantID, String educationTitle);

	public ApplicantEducation retreiveApplicantEducation(String applicantID, String educationTitle);

	public ArrayList<ApplicantEducation> retreiveApplicantEducationsByID(String applicantID);

	public void displayApplicantEducationLogo(String applicantID, String educationTitle, HttpServletResponse response);

	public void updateApplicantEducation(ApplicantEducation education);

	public ArrayList<ApplicantEducation> retreiveApplicantEducations();
}
