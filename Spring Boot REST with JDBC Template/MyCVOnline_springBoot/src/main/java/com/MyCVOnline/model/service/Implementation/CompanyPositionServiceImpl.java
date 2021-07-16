package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.MyCVOnline.model.CompanyEmployee;
import com.MyCVOnline.model.CompanyPosition;
import com.MyCVOnline.model.dao.CompanyPositionDAO;
import com.MyCVOnline.model.service.CompanyPositionService;

@Service("positionService")
public class CompanyPositionServiceImpl implements CompanyPositionService {

	CompanyPositionDAO dao;

	@Override
	public void insertJobPosition(CompanyPosition position, CompanyEmployee employee) {
		// TODO Auto-generated method stub
		dao.insertJobPosition(position, employee);
	}

	@Override
	public void deleteJobPosition(String positionID) {
		// TODO Auto-generated method stub
		dao.deleteJobPosition(positionID);
	}

	@Override
	public CompanyPosition retreiveJobPosition(String positionID) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPosition(positionID);
	}

	@Override
	public void updateJobPosition(CompanyPosition position) {
		// TODO Auto-generated method stub
		CompanyPosition entity = dao.retreiveJobPosition(position.getPositionID());

		if (entity != null) {
			entity.setPositionID(position.getPositionID());
			entity.setJobTitle(position.getJobTitle());
			entity.setJobDescription(position.getJobDescription());
			entity.setJobDomain(position.getJobDomain());
			entity.setAvailability(position.getAvailability());
			entity.setOfferSalary(position.getOfferSalary());
			entity.setAdditionalCompensation(position.getAdditionalCompensation());

			dao.updateJobPosition(entity);
		}
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositions() {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositions();
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyID(String companyID) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositionsByCompanyID(companyID);
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositionsByCompanyName(companyName);
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositionsByCity(String city) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositionsByCity(city);
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositionsByCountry(String country) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositionsByCountry(country);
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositionsByDomain(String domain) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositionsByDomain(domain);
	}

	@Override
	public ArrayList<CompanyPosition> retreiveJobPositionsByTypeOfJob(String typeOfJob) {
		// TODO Auto-generated method stub
		return dao.retreiveJobPositionsByTypeOfJob(typeOfJob);
	}

	@Override
	public boolean isPositionIDUnique(String positionID) {
		// TODO Auto-generated method stub
		CompanyPosition position = dao.retreiveJobPosition(positionID);

		return (position == null);
	}

}
