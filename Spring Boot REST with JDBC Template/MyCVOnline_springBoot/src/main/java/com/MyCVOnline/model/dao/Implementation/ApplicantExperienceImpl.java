package com.MyCVOnline.model.dao.Implementation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.ApplicantExperience;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicantExperienceDAO;

@Repository("applicantExperienceDAO")
public class ApplicantExperienceImpl extends AbstractDAO<ApplicantExperience> implements ApplicantExperienceDAO {

	@Transactional
	public void insertApplicantExperience(Applicant applicant, ApplicantExperience experience) {
		
		experience.setApplicant(applicant);
		
		save(experience);

	}

	@Transactional
	public void deleteApplicantExperience(String applicantID, String experienceTitle) {
		
		Query query = getSession().createQuery("DELETE FROM ApplicantExperience WHERE applicant_id = :applicantID AND experience_title = :experienceTitle ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("experienceTitle", experienceTitle);

		query.executeUpdate();
	}

	@Transactional
	public ApplicantExperience retreiveApplicantExperience(String applicantID, String experienceTitle) {
		
		Query query = getSession().createQuery("FROM ApplicantExperience WHERE applicant_id = :applicantID AND experience_title = :experienceTitle ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("experienceTitle", experienceTitle);
		
		ApplicantExperience experience = (ApplicantExperience)query.uniqueResult();
		
		return experience;
	}

	@Transactional
	public ArrayList<ApplicantExperience> retreiveApplicantExperiencesByID(String applicantID) {
		
		Query query = getSession().createQuery("FROM ApplicantExperience WHERE applicant_id = :applicantID ");
		query.setParameter("applicantID", applicantID);
		
		ArrayList<ApplicantExperience> experiences = (ArrayList<ApplicantExperience>)query.getResultList();
		
		return experiences;
	}

	@Transactional
	public void displayApplicantExperienceLogo(String applicantID, String experienceTitle,
			HttpServletResponse response) {
		InputStream in = null; 
		OutputStream out = null;
		BufferedInputStream bufferIN = null;
		BufferedOutputStream bufferOUT = null;
		Query query = null;
		response.setContentType("image/*");
		
		try {

			out = response.getOutputStream();

			query = getSession().createQuery("FROM ApplicantExperience WHERE applicant_id = :applicantID AND experience_title = :experienceTitle ");
			query.setParameter("applicantID", applicantID);
			query.setParameter("experienceTitle", experienceTitle);

			ResultSet result = (ResultSet) query.list();

			if (result.next()) {

				in = result.getBinaryStream("exp_logo");
			} else {
				System.out.println("No picture on record");
				getSession().close();
			}

			bufferIN = new BufferedInputStream(in);
			bufferOUT = new BufferedOutputStream(out);

			int i = 0;

			while ((i = bufferIN.read()) != -1) {

				bufferOUT.write(i);
			}

			getSession().close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Transactional
	public void updateApplicantExperience(ApplicantExperience experience) {
		Query query = getSession().createQuery("UPDATE ApplicantExperience SET "
				+ "EXPERIENCE_TITLE = :experienceTitle,"
				+ "COMPANY_NAME = :companyName,"
				+ "START_DATE = :startDate,"
				+ "END_DATE = :endDate,"
				+ "DESCRIPTION = :description,"
				+ "EXP_LOGO = :expLogo,"
				+ "WHERE applicant_id = :applicantID ");
		query.setParameter("experienceTitle", experience.getExperienceTitle());
		query.setParameter("companyName", experience.getCompanyName());
		query.setParameter("startDate", experience.getStartDate());
		query.setParameter("endDate", experience.getEndDate());
		query.setParameter("description", experience.getDescription());
		query.setParameter("expLogo", experience.getExpLogo());
		query.setParameter("applicantID", experience.getApplicant().getApplicantID());
		
		query.executeUpdate();
	}

	@Transactional
	public ArrayList<ApplicantExperience> retreiveApplicantExperiences() {
		

		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantExperience> applicant_experiences = (ArrayList<ApplicantExperience>) criteria.list();
		
		
		return applicant_experiences;
	}

}
