package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.CPositionExperience;
import com.MyCVOnline.model.CompanyPosition;

public interface PositionExperienceDAO {

	public void insertPositionExperience(CompanyPosition position ,CPositionExperience experience);

	public void deletePositionExperience(String positionID, String experienceName);

	public CPositionExperience retreivePositionExperience(String positionID, String experienceName);

	public ArrayList<CPositionExperience> retreivePositionExperiencesByPost(String positionID);

	public void updatePositionExperience(CPositionExperience experience);

	public ArrayList<CPositionExperience> retreivePositionExperiences();

}
