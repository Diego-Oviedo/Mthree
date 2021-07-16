package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.CompanyEmployee;
import com.MyCVOnline.model.CompanyPosition;

public interface CompanyPositionDAO {

	public void insertJobPosition(CompanyPosition position, CompanyEmployee employee);

	public void deleteJobPosition(String positionID);

	public CompanyPosition retreiveJobPosition(String positionID);

	public void updateJobPosition(CompanyPosition position);

	public ArrayList<CompanyPosition> retreiveJobPositions();

	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyID(String companyID);

	public ArrayList<CompanyPosition> retreiveJobPositionsByCompanyName(String companyName);

	public ArrayList<CompanyPosition> retreiveJobPositionsByCity(String city);

	public ArrayList<CompanyPosition> retreiveJobPositionsByCountry(String country);

	public ArrayList<CompanyPosition> retreiveJobPositionsByDomain(String domain);

	public ArrayList<CompanyPosition> retreiveJobPositionsByTypeOfJob(String typeOfJob);

}
