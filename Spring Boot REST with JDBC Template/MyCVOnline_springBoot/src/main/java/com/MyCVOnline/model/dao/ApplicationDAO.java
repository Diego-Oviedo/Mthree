package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.Application;

public interface ApplicationDAO {

	public void insertApplication(Application application);

	public void deleteApplication(String applicationNumber);

	public Application retreiveApplication(String applicationNumber);

	public ArrayList<Application> retreiveApplications();

	public void updateApplication(Application application);

	public ArrayList<Application> retreiveApplicationsByApplicantID(String applicantID);

	public ArrayList<Application> retreiveApplicationsByCompany(String companyID);

	public ArrayList<Application> retreiveApplicationsByPostID(String jobPostID);

	public ArrayList<Application> retreiveApplicationsByCity(String city);

	public ArrayList<Application> retreiveApplicationsByDomain(String domain);

	public ArrayList<Application> retreiveApplicationsByCountry(String country);

	public ArrayList<Application> retreiveApplicationsByTypeOfJob(String typeOfJob);
	
	public boolean isApplicationNumberAlreadyExists(String applicationNumber);

}
