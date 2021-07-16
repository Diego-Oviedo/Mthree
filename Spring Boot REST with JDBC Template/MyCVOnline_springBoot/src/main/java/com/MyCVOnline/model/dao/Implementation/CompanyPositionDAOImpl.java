package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.CompanyEmployee;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.CompanyPositionDAO;

@Repository("positionDAO")
public class CompanyPositionDAOImpl extends AbstractDAO<CompanyPosition> implements CompanyPositionDAO {

	@Transactional
	public void insertJobPosition(CompanyPosition position, CompanyEmployee employee) {
		 
		position.setCompany(employee.getCompany());
		
		save(position);
		

	}

	@Transactional
	public void deleteJobPosition(String positionID) {
		
		Query query = getSession().createQuery("FROM CompanyPosition WHERE position_id = :positionID ");
		query.setParameter("positionID", positionID);

		CompanyPosition position = (CompanyPosition)query.uniqueResult();
		
		delete(position);
	}

	@Transactional
	public CompanyPosition retreiveJobPosition(String positionID) {
		
		Query query = getSession().createQuery("FROM CompanyPosition WHERE position_id = :positionID ");
		query.setParameter("positionID", positionID);

		CompanyPosition position = (CompanyPosition)query.uniqueResult();
		
		return position;
	}

	@Transactional
	public void updateJobPosition(CompanyPosition position) {
		Query query = getSession().createQuery("UPDATE CompanyPosition "
											+ "job_title = :jobTitle, "
											+ "job_description = :jobDescription, "
											+ "job_domain = :jobDomain, "
											+ "type_of_job = :typeOfJob, "
											+ "availability = :availability, "
											+ "offer_salary = :offerSalary, "
											+ "additional_compensation = :additionalCompensation, "
											+ "WHERE position_id = :positionID ");
				query.setParameter("jobTitle", position.getPositionID());
				query.setParameter("jobDescription", position.getJobDescription());
				query.setParameter("jobDomain", position.getJobDomain());
				query.setParameter("typeOfJob", position.getTypeOfJob());
				query.setParameter("availability", position.getAvailability());
				query.setParameter("offerSalary", position.getOfferSalary());
				query.setParameter("additionalCompensation", position.getAdditionalCompensation());
				query.setParameter("positionID", position.getPositionID());
				
				query.executeUpdate();
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositions() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> company_positions = (ArrayList<CompanyPosition>) criteria.list();
		
		
		return company_positions;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyID(String companyID) {
		
		Query query = getSession().createQuery("FROM CompanyPosition WHERE company_id IN ( company_id FROM Company c WHERE c.company_id :companyID ) ");
		query.setParameter("companyID", companyID);
		
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> positions = (ArrayList<CompanyPosition>)query.getResultList();
		
		return positions;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyName(String companyName) {
		
		Query query = getSession().createQuery("FROM CompanyPosition WHERE company_id IN ( company_id FROM Company c WHERE c.company_name LIKE '%:companyName%' ) ");
		query.setParameter("companyName", companyName);
		
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> positions = (ArrayList<CompanyPosition>)query.getResultList();
		
		return positions;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCity(String city) {

		Query query = getSession().createQuery("FROM CompanyPosition WHERE company_id IN ( company_id FROM Company c WHERE c.city LIKE '%:city%' ) ");
		query.setParameter("city", city);
		
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> positions = (ArrayList<CompanyPosition>)query.getResultList();
		
		return positions;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByCountry(String country) {

		Query query = getSession().createQuery("FROM CompanyPosition WHERE company_id IN ( company_id FROM Company c WHERE c.country LIKE '%:country%' ) ");
		query.setParameter("country", country);
		
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> positions = (ArrayList<CompanyPosition>)query.getResultList();
		
		return positions;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByDomain(String domain) {

		Query query = getSession().createQuery("FROM CompanyPosition WHERE company_id IN ( company_id FROM Company c WHERE c.domain LIKE '%:domain%' ) ");
		query.setParameter("domain", domain);
		
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> positions = (ArrayList<CompanyPosition>)query.getResultList();
		
		return positions;
	}

	@Transactional
	public ArrayList<CompanyPosition> retreiveJobPositionsByTypeOfJob(String typeOfJob) {

		Query query = getSession().createQuery("FROM CompanyPosition WHERE type_of_job LIKE '%:typeOfJob%' ");
		query.setParameter("typeOfJob", typeOfJob);
		
		@SuppressWarnings("unchecked")
		ArrayList<CompanyPosition> positions = (ArrayList<CompanyPosition>)query.getResultList();
		
		return positions;
	}

}
