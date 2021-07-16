package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.MyCVOnline.model.CPositionExperience;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.PositionExperienceDAO;
import com.MyCVOnline.model.service.PositionExperienceService;

@Service("positionExperienceService")
public class PositionExperienceServiceImpl implements PositionExperienceService {

	PositionExperienceDAO dao;

	@Override
	public void insertPositionExperience(CompanyPosition position ,CPositionExperience experience) {
		// TODO Auto-generated method stub
		dao.insertPositionExperience(position,experience);
	}

	@Override
	public void deletePositionExperience(String positionID, String experienceName) {
		// TODO Auto-generated method stub
		dao.deletePositionExperience(positionID, experienceName);
	}

	@Override
	public CPositionExperience retreivePositionExperience(String positionID, String experienceName) {
		// TODO Auto-generated method stub
		return dao.retreivePositionExperience(positionID, experienceName);
	}

	@Override
	public ArrayList<CPositionExperience> retreivePositionExperiencesByPost(String positionID) {
		// TODO Auto-generated method stub
		return dao.retreivePositionExperiencesByPost(positionID);
	}

	@Override
	public void updatePositionExperience(CPositionExperience experience) {
		// TODO Auto-generated method stub

		CPositionExperience entity = dao.retreivePositionExperience(experience.getPosition().getPositionID(),
				experience.getExperienceName());

		if (entity != null) {

			entity.setPosition(experience.getPosition());
			entity.setExperienceName(experience.getExperienceName());
			entity.setDesiredYears(experience.getDesiredYears());
			entity.setExperienceDescription(experience.getExperienceDescription());

			dao.updatePositionExperience(entity);

		}

	}

	@Override
	public ArrayList<CPositionExperience> retreivePositionExperiences() {
		// TODO Auto-generated method stub
		return dao.retreivePositionExperiences();
	}

}
