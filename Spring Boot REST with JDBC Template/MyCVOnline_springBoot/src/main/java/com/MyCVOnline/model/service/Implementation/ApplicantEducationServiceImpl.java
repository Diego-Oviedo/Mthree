package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantEducation;
import com.MyCVOnline.model.dao.ApplicantEducationDAO;
import com.MyCVOnline.model.service.ApplicantEducationService;

@Service("applicantEducationService")
public class ApplicantEducationServiceImpl implements ApplicantEducationService {
	
	@Autowired
	private ApplicantEducationDAO dao;

	@Override
	public void insertApplicantEducation(Applicant applicant,ApplicantEducation education) {
		// TODO Auto-generated method stub
		dao.insertApplicantEducation(applicant,education);
	}

	@Override
	public void deleteApplicantEducation(String applicantID, String educationTitle) {
		// TODO Auto-generated method stub
		dao.deleteApplicantEducation(applicantID, educationTitle);
	}

	@Override
	public ApplicantEducation retreiveApplicantEducation(String applicantID, String educationTitle) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantEducation(applicantID, educationTitle);
	}

	@Override
	public ArrayList<ApplicantEducation> retreiveApplicantEducationsByID(String applicantID) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantEducationsByID(applicantID);
	}

	@Override
	public void displayApplicantEducationLogo(String applicantID, String educationTitle, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao.displayApplicantEducationLogo(applicantID, educationTitle, response);
	}

	@Override
	public void updateApplicantEducation(ApplicantEducation education) {
		// TODO Auto-generated method stub
		ApplicantEducation entity = dao.retreiveApplicantEducation(education.getApplicant().getApplicantID(),
				education.getEducationTitle());

		if (entity != null) {
			entity.setApplicant(education.getApplicant());
			entity.setEducationTitle(education.getEducationTitle());
			entity.setSchoolName(education.getSchoolName());
			entity.setStartDate(education.getStartDate());
			entity.setEndDate(education.getEndDate());
			entity.setDescription(education.getDescription());
			entity.setEduLogo(education.getEduLogo());

			dao.updateApplicantEducation(entity);
		}
	}

	@Override
	public ArrayList<ApplicantEducation> retreiveApplicantEducations() {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantEducations();
	}

}
