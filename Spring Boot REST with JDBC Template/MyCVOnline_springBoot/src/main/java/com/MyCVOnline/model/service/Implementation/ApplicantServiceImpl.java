package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.dao.ApplicantDAO;
import com.MyCVOnline.model.service.ApplicantService;

@Service("applicantService")
class ApplicantServiceImpl implements ApplicantService {
	
	@Autowired
	private ApplicantDAO dao;

	@Override
	public void insertApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		dao.insertApplicant(applicant);
	}

	@Override
	public void insertApplicantAboutYou(String applicantID, String aboutYou) {
		// TODO Auto-generated method stub
		Applicant entity = dao.retreiveApplicant(applicantID);
		if (entity != null) {

			dao.insertApplicantAboutYou(applicantID, aboutYou);

		}
	}

	@Override
	public void deleteApplicant(String applicnatID) {
		// TODO Auto-generated method stub
		dao.deleteApplicant(applicnatID);
	}

	@Override
	public Applicant retreiveApplicant(String applicantID) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicant(applicantID);
	}

	@Override
	public Applicant retreiveUser(String username) {
		// TODO Auto-generated method stub
		return dao.retreiveUser(username);
	}

	@Override
	public void updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		Applicant entity = dao.retreiveApplicant(applicant.getApplicantID());
		if (entity != null) {
			entity.setUsername(applicant.getUsername());
			entity.setPassword(applicant.getPassword());
			entity.setFirstName(applicant.getFirstName());
			entity.setLastName(applicant.getLastName());
			entity.setAboutYou(applicant.getAboutYou());
			entity.setProfession(applicant.getProfession());
			entity.setPhoneNumber(applicant.getPhoneNumber());
			entity.setEmail(applicant.getEmail());
			entity.setStreetAddress(applicant.getStreetAddress());
			entity.setPostalCode(applicant.getPostalCode());
			entity.setCity(applicant.getCity());
			entity.setProvince(applicant.getProvince());
			entity.setCountry(applicant.getCountry());
			entity.setProfilePicture(applicant.getProfilePicture());

			dao.updateApplicant(entity);
		}
	}

	@Override
	public void displayApplicantProfilePicture(String applicantID, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao.displayApplicantProfilePicture(applicantID, response);
	}

	@Override
	public ArrayList<Applicant> retreiveApplicants() {
		// TODO Auto-generated method stub
		return dao.retreiveApplicants();
	}

	@Override
	public boolean isApplicantIDAlreadyExists(String applicantID) {
		// TODO Auto-generated method stub
		return dao.isApplicantIDAlreadyExists(applicantID);
	}
	
	@Override
	public boolean isApplicantUsernameAlreadyExists(String username) {
		// TODO Auto-generated method stub
		return dao.isApplicantUsernameAlreadyExists(username);
	}


}
