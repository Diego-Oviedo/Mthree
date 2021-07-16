package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.MyCVOnline.model.Application;
import com.MyCVOnline.model.dao.ApplicationDAO;
import com.MyCVOnline.model.service.ApplicationService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

	ApplicationDAO dao;

	@Override
	public void insertApplication(Application application) {
		// TODO Auto-generated method stub
		dao.insertApplication(application);
	}

	@Override
	public void deleteApplication(String applicationNumber) {
		// TODO Auto-generated method stub
		dao.deleteApplication(applicationNumber);
	}


	@Override
	public Application retreiveApplication(String application) {
		// TODO Auto-generated method stub
		return dao.retreiveApplication(application);
	}

	@Override
	public ArrayList<Application> retreiveApplications() {
		// TODO Auto-generated method stub
		return dao.retreiveApplications();
	}

	@Override
	public void updateApplication(Application application) {
		// TODO Auto-generated method stub
		Application entity = dao.retreiveApplication(application.getApplicationNumber());

		if (entity != null) {
			entity.setApplicationNumber(application.getApplicationNumber());
			entity.setApplicationDate(application.getApplicationDate());
			entity.setApplicant(application.getApplicant());
			entity.setPosition(application.getPosition());

			dao.updateApplication(entity);
		}
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByApplicantID(String applicantID) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByApplicantID(applicantID);
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByCompany(String companyID) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByCompany(companyID);
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByPostID(String jobPostID) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByPostID(jobPostID);
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByCity(String city) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByCity(city);
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByDomain(String domain) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByDomain(domain);
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByCountry(String country) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByCountry(country);
	}

	@Override
	public ArrayList<Application> retreiveApplicationsByTypeOfJob(String typeOfJob) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicationsByTypeOfJob(typeOfJob);
	}

	@Override
	public boolean isApplicationNumberAlreadyExists(String applicationNumber) {
		// TODO Auto-generated method stub

		return dao.isApplicationNumberAlreadyExists(applicationNumber);
	}

}
