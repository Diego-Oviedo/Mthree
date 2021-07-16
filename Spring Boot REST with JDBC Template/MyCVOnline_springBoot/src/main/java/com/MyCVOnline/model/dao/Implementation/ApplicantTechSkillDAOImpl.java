package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantTechSkill;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicantTechSkillDAO;

@Repository("applicantTechSkillDAO")
public class ApplicantTechSkillDAOImpl extends AbstractDAO<ApplicantTechSkill> implements ApplicantTechSkillDAO {

	@Transactional
	public void insertApplicantTechSkill(Applicant applicant, ApplicantTechSkill techSkill) {
		
		techSkill.setApplicant(applicant);
		save(techSkill);

	}

	@Transactional
	public void deleteApplicantTechSkill(String applicantID, String skillName) {
		Query query = getSession().createQuery("DELETE FROM ApplicantTechSkill WHERE applicant_id = :applicantID AND skill_name = :skillName ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("skillName", skillName);
		
		query.executeUpdate();
		
	}

	@Transactional
	public ApplicantTechSkill retreiveApplicantTechSkill(String applicantID, String skillName) {
		
		Query query = getSession().createQuery("FROM ApplicantTechSkill WHERE applicant_id = :applicantID AND skill_name = :skillName ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("skillName", skillName);
		
		ApplicantTechSkill techSkilll = (ApplicantTechSkill)query.uniqueResult();
		
		return techSkilll;
	}

	@Transactional
	public ArrayList<ApplicantTechSkill> retreiveAppicantTechnicalSkillsByID(String applicantID) {
		
		Query query = getSession().createQuery("FROM ApplicantTechSkill WHERE applicant_id = :applicantID ");
		query.setParameter("applicantID", applicantID);
		
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantTechSkill> techSkilll = (ArrayList<ApplicantTechSkill>)query.getResultList();
		
		return techSkilll;
	}

	@Transactional
	public void updateApplicantTechSkill(ApplicantTechSkill techSkill) {
		Query query = getSession().createQuery("UPDATE ApplicantTechSkill"
				+ " SKILL_NAME = :skillName "
				+ "WHERE applicant_id = :applicantID ");
			query.setParameter("skillName", techSkill.getSkillName());
			query.setParameter("applicantID", techSkill.getApplicant().getApplicantID());
			
			query.executeUpdate();

	}

	@Transactional
	public ArrayList<ApplicantTechSkill> retreiveAppicantTechnicalSkills() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantTechSkill> applicant_techSkills = (ArrayList<ApplicantTechSkill>) criteria.list();
		
		return applicant_techSkills;
	}

}
