package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantExperience;
import com.MyCVOnline.model.dao.ApplicantExperienceDAO;
import com.MyCVOnline.model.service.ApplicantExperienceService;

@Service("applicantExperienceService")
public class ApplicantExperienceServiceImpl implements ApplicantExperienceService {
	
	@Autowired
	ApplicantExperienceDAO dao;

	@Override
	public void insertApplicantExperience(Applicant applicant,ApplicantExperience experience) {
		// TODO Auto-generated method stub
		dao.insertApplicantExperience(applicant,experience);
	}

	@Override
	public void deleteApplicantExperience(String applicantID, String experienceTitle) {
		// TODO Auto-generated method stub
		dao.deleteApplicantExperience(applicantID, experienceTitle);
	}

	@Override
	public void retreiveApplicantExperience(String applicantID, String experienceTitle) {
		// TODO Auto-generated method stub
		dao.retreiveApplicantExperience(applicantID, experienceTitle);
	}

	@Override
	public ArrayList<ApplicantExperience> retreiveApplicantExperiencesByID(String applicantID) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantExperiencesByID(applicantID);
	}

	@Override
	public void displayApplicantExperienceLogo(String applicantID, String experienceTitle,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao.displayApplicantExperienceLogo(applicantID, experienceTitle, response);
	}

	@Override
	public void updateApplicantExperience(ApplicantExperience experience) {
		// TODO Auto-generated method stub
		ApplicantExperience entity = dao.retreiveApplicantExperience(experience.getApplicant().getApplicantID(),
				experience.getExperienceTitle());

		if (entity != null) {
			entity.setApplicant(experience.getApplicant());
			entity.setExperienceTitle(experience.getExperienceTitle());
			entity.setCompanyName(experience.getCompanyName());
			entity.setStartDate(experience.getStartDate());
			entity.setEndDate(experience.getEndDate());
			entity.setDescription(experience.getDescription());
			entity.setExpLogo(experience.getExpLogo());

			dao.updateApplicantExperience(entity);
		}

	}

	@Override
	public ArrayList<ApplicantExperience> retreiveApplicantExperiences() {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantExperiences();
	}

}
