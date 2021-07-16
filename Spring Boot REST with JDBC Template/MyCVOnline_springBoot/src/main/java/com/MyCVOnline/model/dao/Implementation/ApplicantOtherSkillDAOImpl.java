package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.Applicant; 
import com.MyCVOnline.model.ApplicantOtherSkill;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicantOtherSkillDAO;

@Repository("applicantOtherSkillDAO")
public class ApplicantOtherSkillDAOImpl extends AbstractDAO<ApplicantOtherSkill>  implements ApplicantOtherSkillDAO {

	@Transactional
	public void insertApplicantOtherSkill(Applicant applicant, ApplicantOtherSkill otherSkill) {

		otherSkill.setApplicant(applicant);
		save(otherSkill);
		
	}

	@Transactional
	public void deleteApplicantOtherSkill(String applicantID, String skillName) {
		
		Query query = getSession().createQuery("DELETE FROM ApplicantOtherSkillDAOImpl WHERE applicant_id = :applicantID AND skill_name = :skillName ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("skillName", skillName);

		query.executeUpdate();

	}

	@Transactional
	public ApplicantOtherSkill retreiveApplicantOtherSkill(String applicantID, String skillName) {
		
		Query query = getSession().createQuery("FROM ApplicantOtherSkillDAOImpl WHERE applicant_id = :applicantID AND skill_name = :skillName ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("skillName", skillName);
		
		ApplicantOtherSkill otherSkill = (ApplicantOtherSkill)query.uniqueResult();
		
		return otherSkill;
	}

	@Transactional
	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkillsByID(String applicantID) {
		
		Query query = getSession().createQuery("FROM ApplicantOtherSkillDAOImpl WHERE applicant_id = :applicantID ");
		query.setParameter("applicantID", applicantID);
		
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantOtherSkill> otherSkills = (ArrayList<ApplicantOtherSkill>)query.getResultList();
		
		return otherSkills;
	}

	@Transactional
	public void updateApplicantOtherSkill(ApplicantOtherSkill otherSkill) {
		
		Query query = getSession().createQuery("UPDATE ApplicantOtherSkillDAOImpl "
								+ " SKILL_NAME = :skillName "
								+ "WHERE applicant_id = :applicantID ");
		query.setParameter("skillName", otherSkill.getSkillName());
		query.setParameter("applicantID", otherSkill.getApplicant().getApplicantID());
		
		query.executeUpdate();

	}

	@Transactional
	public ArrayList<ApplicantOtherSkill> retreiveAppicantOtherSkills() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantOtherSkill> applicant_otherSkills = (ArrayList<ApplicantOtherSkill>) criteria.list();
		
		
		return applicant_otherSkills;
	}

}
