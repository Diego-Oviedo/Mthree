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
import com.MyCVOnline.model.ApplicantEducation;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicantEducationDAO;


@Repository("applicantEducationDAO")
public class ApplicantEducationDAOImpl extends AbstractDAO<ApplicantEducation> implements ApplicantEducationDAO {
	
	@Transactional
	public void insertApplicantEducation(Applicant applicant,ApplicantEducation education) {
		
		education.setApplicant(applicant);
		save(education);
		
	}

	@Transactional
	public void deleteApplicantEducation(String applicantID, String educationTitle) {
		
		Query query = getSession().createQuery("DELETE FROM ApplicantEducation WHERE applicant_id = :applicantID AND education_title = :educationTitle ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("educationTitle", educationTitle);
		
		query.executeUpdate();

	}

	@Transactional
	public ApplicantEducation retreiveApplicantEducation(String applicantID, String educationTitle) {
		
		Query query = getSession().createQuery("FROM ApplicantEducation WHERE applicant_id = :applicantID AND education_title = :educationTitle ");
		query.setParameter("applicantID", applicantID);
		query.setParameter("educationTitle", educationTitle);
		
		
		ApplicantEducation education = (ApplicantEducation)query.uniqueResult();
		
		
		return education;
	}

	@Transactional
	public ArrayList<ApplicantEducation> retreiveApplicantEducationsByID(String applicantID) {
		
		Query query = getSession().createQuery("FROM ApplicantEducation WHERE applicant_id = :applicantID ");
		query.setParameter("applicantID", applicantID);
		
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantEducation> educations = (ArrayList<ApplicantEducation>)query.getResultList();
		
		
		return educations;
	}

	@Transactional
	public void displayApplicantEducationLogo(String applicantID, String educationTitle, HttpServletResponse response) {
		InputStream in = null; 
		OutputStream out = null;
		BufferedInputStream bufferIN = null;
		BufferedOutputStream bufferOUT = null;
		Query query = null;
		response.setContentType("image/*");
		
		try {

			out = response.getOutputStream();

			query = getSession().createQuery("FROM ApplicantEducation WHERE applicant_id = :applicantID AND education_title = :educationTitle ");
			query.setParameter("applicantID", applicantID);
			query.setParameter("educationTitle", educationTitle);

			ResultSet result = (ResultSet) query.list();

			if (result.next()) {

				in = result.getBinaryStream("edu_logo");
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
	public void updateApplicantEducation(ApplicantEducation education) {
		
		Query query = getSession().createQuery("UPDATE ApplicantEducation SET "
												+ "EDUCATION_TITLE = :educationTitle,"
												+ "SCHOOL_NAME = :schoolName,"
												+ "START_DATE = :startDate,"
												+ "END_DATE = :endDate,"
												+ "DESCRIPTION = :description,"
												+ "EDU_LOGO = :eduLogo,"
												+ "WHERE applicant_id = :applicantID ");
		query.setParameter("educationTitle", education.getEducationTitle());
		query.setParameter("schoolName", education.getSchoolName());
		query.setParameter("startDate", education.getStartDate());
		query.setParameter("endDate", education.getEndDate());
		query.setParameter("description", education.getDescription());
		query.setParameter("eduLogo", education.getEduLogo());
		query.setParameter("applicantID", education.getApplicant().getApplicantID());

		query.executeUpdate();
	}

	@Transactional
	public ArrayList<ApplicantEducation> retreiveApplicantEducations() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<ApplicantEducation> applicant_educations = (ArrayList<ApplicantEducation>) criteria.list();
		
		/*
		//Lamda expession 
		
		applicant_educations.forEach(education -> System.out.println(education));
			//metodos a referencia 
		applicant_educations.forEach(System.out::println);
		*/
		
		
		return applicant_educations;
	}

}
