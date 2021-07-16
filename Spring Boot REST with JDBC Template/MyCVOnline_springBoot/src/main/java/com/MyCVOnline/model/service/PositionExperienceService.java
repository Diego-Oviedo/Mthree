package com.MyCVOnline.model.service;

import java.util.ArrayList;
import com.MyCVOnline.model.*;

public interface PositionExperienceService {

	public void insertPositionExperience(CompanyPosition position ,CPositionExperience experience);

	public void deletePositionExperience(String positionID, String experienceName);

	public CPositionExperience retreivePositionExperience(String positionID, String experienceName);

	public ArrayList<CPositionExperience> retreivePositionExperiencesByPost(String positionID);

	public void updatePositionExperience(CPositionExperience experience);

	public ArrayList<CPositionExperience> retreivePositionExperiences();

}
