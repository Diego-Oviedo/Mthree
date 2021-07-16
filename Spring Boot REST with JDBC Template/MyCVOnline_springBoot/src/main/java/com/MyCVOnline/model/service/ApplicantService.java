package com.MyCVOnline.model.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import com.MyCVOnline.model.*;

public interface ApplicantService {

	public void insertApplicant(Applicant applicant);

	public void insertApplicantAboutYou(String applicantID, String aboutYou);

	public void deleteApplicant(String applicnatID);

	public Applicant retreiveApplicant(String applicantID);

	public Applicant retreiveUser(String username);

	public void updateApplicant(Applicant applicant);

	public void displayApplicantProfilePicture(String applicantID, HttpServletResponse response);

	public ArrayList<Applicant> retreiveApplicants();

	public boolean isApplicantIDAlreadyExists(String applicantID);
	
	public boolean isApplicantUsernameAlreadyExists(String username);

}
