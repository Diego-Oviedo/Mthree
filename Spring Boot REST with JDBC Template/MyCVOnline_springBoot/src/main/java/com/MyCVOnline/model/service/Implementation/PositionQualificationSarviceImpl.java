package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.MyCVOnline.model.CPositionQualification;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.PositionQualificationDAO;
import com.MyCVOnline.model.service.PositionQualificationSarvice;

@Service("positionQualificationService")
public class PositionQualificationSarviceImpl implements PositionQualificationSarvice {

	PositionQualificationDAO dao;

	@Override
	public void insertPositionQualification(CompanyPosition position ,CPositionQualification qualification) {
		// TODO Auto-generated method stub
		dao.insertPositionQualification(position, qualification);
	}

	@Override
	public void deletePositionQualification(String positionID, String qualificationName) {
		// TODO Auto-generated method stub
		dao.deletePositionQualification(positionID, qualificationName);
	}

	@Override
	public CPositionQualification retreivePositionQualification(String positionID, String qualificationName) {
		// TODO Auto-generated method stub
		return dao.retreivePositionQualification(positionID, qualificationName);
	}

	@Override
	public ArrayList<CPositionQualification> retreivePositionQualificationsByPost(String positionID) {
		// TODO Auto-generated method stub
		return dao.retreivePositionQualificationsByPost(positionID);
	}

	@Override
	public void updatePositionQualification(CPositionQualification qualification) {
		// TODO Auto-generated method stub
		CPositionQualification entity = dao.retreivePositionQualification(qualification.getPosition().getPositionID(),
				qualification.getQualificationName());

		if (entity != null) {

			entity.setPosition(qualification.getPosition());
			entity.setQualificationName(qualification.getQualificationName());
			entity.setDesiredYears(qualification.getDesiredYears());
			entity.setQualificationDescription(qualification.getQualificationDescription());

			dao.updatePositionQualification(entity);

		}

	}

	@Override
	public ArrayList<CPositionQualification> retreivePositionQualifications() {
		// TODO Auto-generated method stub
		return dao.retreivePositionQualifications();
	}

}
