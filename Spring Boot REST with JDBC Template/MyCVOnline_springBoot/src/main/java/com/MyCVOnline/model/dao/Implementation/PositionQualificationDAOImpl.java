package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.CPositionQualification;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.PositionQualificationDAO;

@Repository("positionQualificationDAO")
public class PositionQualificationDAOImpl extends AbstractDAO<CPositionQualification> implements PositionQualificationDAO {

	@Transactional
	public void insertPositionQualification(CompanyPosition position, CPositionQualification qualification) {
		
		qualification.setPosition(position);
		
		save(qualification);
	}

	@Transactional
	public void deletePositionQualification(String positionID, String qualificationName) {

		Query query = getSession().createQuery("FROM CPositionQualification WHERE position_id = :positionID AND qualification_name = :qualificationName ");
		query.setParameter("positionID", positionID);
		query.setParameter("qualificationName", qualificationName);
		
		CPositionQualification qualification = (CPositionQualification)query.uniqueResult();
		
		delete(qualification);

	}

	@Transactional
	public CPositionQualification retreivePositionQualification(String positionID, String qualificationName) {
		
		Query query = getSession().createQuery("FROM CPositionQualification WHERE position_id = :positionID AND qualification_name = :qualificationName ");
		query.setParameter("positionID", positionID);
		query.setParameter("qualificationName", qualificationName);
		
		CPositionQualification qualification = (CPositionQualification)query.uniqueResult();
		
		return qualification;
	}

	@Transactional
	public ArrayList<CPositionQualification> retreivePositionQualificationsByPost(String positionID) {

		Query query = getSession().createQuery("FROM CPositionQualification WHERE position_id = :positionID ");
		query.setParameter("positionID", positionID);
		
		@SuppressWarnings("unchecked")
		ArrayList<CPositionQualification> qualification = (ArrayList<CPositionQualification>)query.getResultList();
		
		
		return qualification;
	}

	@Transactional
	public void updatePositionQualification(CPositionQualification qualification) {

		Query query = getSession().createQuery("UPDATE CPositionQualification"
				+ " qualification_name = :qualificationName, "
				+ " desired_years = :desiredYears, "
				+ " qualification_description = :qualificationDescription "
				+ "WHERE position_id = :positionID ");
			query.setParameter("experienceName", qualification.getQualificationName());
			query.setParameter("desiredYears", qualification.getDesiredYears());
			query.setParameter("experienceDescription", qualification.getQualificationDescription());
			query.setParameter("positionID", qualification.getPosition().getPositionID());
			
			query.executeUpdate();

	}

	@Transactional
	public ArrayList<CPositionQualification> retreivePositionQualifications() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<CPositionQualification> qualifications = (ArrayList<CPositionQualification>) criteria.list();
		
		return qualifications;
	}

}
