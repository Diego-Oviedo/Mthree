package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantTechSkill;
import com.MyCVOnline.model.dao.ApplicantTechSkillDAO;
import com.MyCVOnline.model.service.ApplicantTechSkillService;

@Service("applicantTechSkillService")
public class ApplicantTechSkillServiceImpl implements ApplicantTechSkillService {

	ApplicantTechSkillDAO dao;

	@Override
	public void insertApplicantTechSkill(Applicant applicant,ApplicantTechSkill techSkill) {
		// TODO Auto-generated method stub
		dao.insertApplicantTechSkill(applicant,techSkill);
	}

	@Override
	public void deleteApplicantTechSkill(String applicantID, String skillName) {
		// TODO Auto-generated method stub
		dao.deleteApplicantTechSkill(applicantID, skillName);
	}

	@Override
	public ApplicantTechSkill retreiveApplicantTechSkill(String applicantID, String skillName) {
		// TODO Auto-generated method stub
		return dao.retreiveApplicantTechSkill(applicantID, skillName);
	}

	@Override
	public ArrayList<ApplicantTechSkill> retreiveAppicantTechnicalSkillsByID(String applicantID) {
		// TODO Auto-generated method stub
		return dao.retreiveAppicantTechnicalSkillsByID(applicantID);
	}

	@Override
	public void updateApplicantTechSkill(ApplicantTechSkill techSkill) {
		// TODO Auto-generated method stub
		ApplicantTechSkill entity = dao.retreiveApplicantTechSkill(techSkill.getApplicant().getApplicantID(),
				techSkill.getSkillName());

		entity.setApplicant(techSkill.getApplicant());
		entity.setSkillName(techSkill.getSkillName());

		dao.updateApplicantTechSkill(entity);
	}

	@Override
	public ArrayList<ApplicantTechSkill> retreiveAppicantTechnicalSkills() {
		// TODO Auto-generated method stub
		return dao.retreiveAppicantTechnicalSkills();
	}

}
