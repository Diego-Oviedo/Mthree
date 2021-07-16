package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantOtherSkill;
import com.MyCVOnline.model.dao.ApplicantOtherSkillDAO;
import com.MyCVOnline.model.service.ApplicantOtherSkillService;

@Service("applicantOtherSkillService")
public class ApplicantOtherSkillServiceImpl implements ApplicantOtherSkillService {

	ApplicantOtherSkillDAO dao;

	@Override
	public void insertApplicantOtherSkill(Applicant applicant,ApplicantOtherSkill otherSkill) {
		// TODO Auto-generated method stub
		dao.insertApplicantOtherSkill(applicant,otherSkill);
	}

	@Override
	public void deleteApplicantOtherSkill(String applicantID, String skillName) {
		// TODO Auto-generated method stub
		dao.deleteApplicantOtherSkill(applicantID, skillName);
	}

	@Override
	public ApplicantOtherSkill retreiveApplicantOtherSkill(String applicantID, String skillName) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantOtherSkill(applicantID, skillName);
	}

	@Override
	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkillsByID(String applicantID) {
		// TODO Auto-generated method stub
		return dao.retreiveAppicantOtherSkillsByID(applicantID);
	}

	@Override
	public void updateApplicantOtherSkill(ApplicantOtherSkill otherSkill) {
		// TODO Auto-generated method stub

		ApplicantOtherSkill entity = dao.retreiveApplicantOtherSkill(otherSkill.getApplicant().getApplicantID(),
				otherSkill.getSkillName());

		if (entity != null) {
			entity.setApplicant(otherSkill.getApplicant());
			entity.setSkillName(otherSkill.getSkillName());
			dao.updateApplicantOtherSkill(entity);
		}

	}

	@Override
	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkills() {
		// TODO Auto-generated method stub
		return dao.retreiveAppicantOtherSkills();
	}

}
