package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.CPositionExperience;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.PositionExperienceDAO;


@Repository("positionExperienceDAO")
public class PositionExperienceDAOImpl extends AbstractDAO<CPositionExperience> implements PositionExperienceDAO {

	@Transactional
	public void insertPositionExperience(CompanyPosition position, CPositionExperience experience) {
		
		experience.setPosition(position);
		
		save(experience);

	}

	@Transactional
	public void deletePositionExperience(String positionID, String experienceName) {
		
		Query query = getSession().createQuery("FROM CPositionExperience WHERE position_id = :positionID AND experience_name = :experienceName ");
		query.setParameter("positionID", positionID);
		query.setParameter("experienceName", experienceName);
		
		CPositionExperience experience = (CPositionExperience)query.uniqueResult();
		
		delete(experience);

	}

	@Transactional
	public CPositionExperience retreivePositionExperience(String positionID, String experienceName) {
		
		Query query = getSession().createQuery("FROM CPositionExperience WHERE position_id = :positionID AND experience_name = :experienceName ");
		query.setParameter("positionID", positionID);
		query.setParameter("experienceName", experienceName);
		
		CPositionExperience experience = (CPositionExperience)query.uniqueResult();

		return experience;
	}

	@Transactional
	public ArrayList<CPositionExperience> retreivePositionExperiencesByPost(String positionID) {

		Query query = getSession().createQuery("FROM CPositionExperience WHERE position_id = :positionID ");
		query.setParameter("positionID", positionID);
		
		@SuppressWarnings("unchecked")
		ArrayList<CPositionExperience> experiences = (ArrayList<CPositionExperience>)query.getResultList();
		
		
		return experiences;
	}

	@Transactional
	public void updatePositionExperience(CPositionExperience experience) {
		
		Query query = getSession().createQuery("UPDATE CPositionExperience"
				+ " experience_name = :experienceName, "
				+ " experience_years = :desiredYears, "
				+ " experience_description = :experienceDescription "
				+ "WHERE position_id = :positionID ");
			query.setParameter("experienceName", experience.getExperienceName());
			query.setParameter("desiredYears", experience.getDesiredYears());
			query.setParameter("experienceDescription", experience.getExperienceDescription());
			query.setParameter("positionID", experience.getPosition().getPositionID());
			
			query.executeUpdate();

	}

	@Transactional
	public ArrayList<CPositionExperience> retreivePositionExperiences() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<CPositionExperience> experiences = (ArrayList<CPositionExperience>) criteria.list();

		
		return experiences;
	}

}
