package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.Application;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicationDAO;

@Repository("applicationDAO")
public class ApplicationDAOImpl extends AbstractDAO<Application> implements ApplicationDAO {

	@Transactional
	public void insertApplication(Application application) {
		
		String ID = applicationIDGenerator();
		
		application.setApplicationNumber(ID);
		
		save(application);

	}
	
	// This method will handle a creation and a non-unique ID validation.  
	// Logic: If the ID created already exists -> add a digit at the end of the ID 
	public String applicationIDGenerator() {
		
		final String PREFIX = "APCTN"; 
		int APCTN_number = retreiveApplications().size()+1;
		String digits = null ;
		String ID  = null;
		
		
		if (APCTN_number <= 9) {
			
			digits = "0000";
			
			ID = PREFIX + digits + APCTN_number;
			
			if(isApplicationNumberAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCTN_number+1);
			}
			
			
		}else if (APCTN_number <= 99) {
			
			digits = "000";
			
			ID = PREFIX + digits + APCTN_number;
			
			if(isApplicationNumberAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCTN_number+1);
			}
			
		}else if (APCTN_number <= 999) {
			
			digits = "00";
			
			ID = PREFIX + digits + APCTN_number;
			
			if(isApplicationNumberAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCTN_number+1);
			}
			
			
		}else if (APCTN_number <= 9999) {
			
			digits = "0";
			
			ID = PREFIX + digits + APCTN_number;
			
			if(isApplicationNumberAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCTN_number+1);
			}
			
			
		}else if (APCTN_number >= 10000) {	
			
			ID = PREFIX + APCTN_number;
			
			if(isApplicationNumberAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCTN_number+1);
			}
			
		}
		
		return ID;
	}
	
	

	@Transactional
	public void deleteApplication(String applicationNumber) {
		
		Application application = getByID(applicationNumber);
		
		delete(application);

	}

	@Transactional
	public Application retreiveApplication(String applicationNumber) {
		
		Application application = getByID(applicationNumber);
		
		return application;
	}

	@Transactional
	public ArrayList<Application> retreiveApplications() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>) criteria.list();
		
		
		return applicantions;
	}

	@Transactional
	public void updateApplication(Application application) {
		Query query = getSession().createQuery("UPDATE Application "
												+ " application_date = ;applicationDate, "
												+ " applicant_id = ;applicantID, "
												+ " position_id = ;positionID "
												+ "WHERE application_number = :applicationNumber ");
		query.setParameter("applicationDate", application.getApplicationDate());
		query.setParameter("applicantID", application.getApplicant().getApplicantID());
		query.setParameter("positionID", application.getPosition().getPositionID());
		query.setParameter("applicationNumber", application.getApplicationNumber());
		
		query.executeUpdate();
		
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByApplicantID(String applicantID) {
		
		Query query = getSession().createQuery("FROM Application WHERE applicant_id = :applicantID ");
		query.setParameter("applicantID", applicantID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByCompany(String companyID) {
		
		Query query = getSession().createQuery("FROM Application WHERE position_id IN ( position_id FROM Company WHERE company_id LIKE '%:companyID%' ) ");
		query.setParameter("companyID", companyID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
		
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByPostID(String jobPostID) {
		
		Query query = getSession().createQuery("FROM Application WHERE position_id = :jobPostID ");
		query.setParameter("jobPostID", jobPostID);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByCity(String city) {
		
		Query query = getSession().createQuery("FROM Application WHERE position_id IN ( position_id FROM Company c WHERE c.city LIKE '%:city%' UNION FROM Applicant a WHERE a.city LIKE '%:city%' ) ");
		query.setParameter("city", city);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByDomain(String domain) {

		Query query = getSession().createQuery("FROM Application WHERE position_id IN ( position_id FROM Company WHERE job_domain LIKE '%:domain%' ) ");
		query.setParameter("domain", domain);
		
		@SuppressWarnings("unchecked") 
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByCountry(String country) {

		Query query = getSession().createQuery("FROM Application WHERE position_id IN ( position_id FROM Company c WHERE c.country LIKE '%:country%' UNION FROM Applicant a WHERE a.country LIKE '%:country%' ) ");
		query.setParameter("country", country);
		
		@SuppressWarnings("unchecked")
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
	}

	@Transactional
	public ArrayList<Application> retreiveApplicationsByTypeOfJob(String typeOfJob) {
		
		Query query = getSession().createQuery("FROM Application WHERE position_id IN ( position_id FROM Company WHERE type_of_job = :typeOfJob ) ");
		query.setParameter("typeOfJob", typeOfJob);
		
		@SuppressWarnings("unchecked") 
		ArrayList<Application> applicantions = (ArrayList<Application>)query.getResultList();
		
		return applicantions;
		
	}

	public boolean isApplicationNumberAlreadyExists(String applicationNumber) {
		
		Application application = getByID(applicationNumber);
		
		return (application != null);
		
	};
	
}
