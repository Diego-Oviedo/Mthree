package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.CPositionQualification;
import com.MyCVOnline.model.CompanyPosition;

public interface PositionQualificationDAO {

	public void insertPositionQualification(CompanyPosition position ,CPositionQualification qualification);

	public void deletePositionQualification(String positionID, String qualificationName);

	public CPositionQualification retreivePositionQualification(String positionID, String qualificationName);

	public ArrayList<CPositionQualification> retreivePositionQualificationsByPost(String positionID);

	public void updatePositionQualification(CPositionQualification qualification);

	public ArrayList<CPositionQualification> retreivePositionQualifications();

}
