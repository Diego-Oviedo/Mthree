package com.MyCVOnline.model.service.Implementation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.MyCVOnline.model.Company;
import com.MyCVOnline.model.dao.CompanyDAO;
import com.MyCVOnline.model.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	CompanyDAO dao;
	
	@Override
	public void insertCompany(Company company) {
		// TODO Auto-generated method stub
		dao.insertCompany(company);
	}

	@Override
	public void deleteCompany(String companyID) {
		// TODO Auto-generated method stub
		dao.deleteCompany(companyID);
	}

	@Override
	public Company retreiveCompany(String companyID) {
		// TODO Auto-generated method stub
		return dao.retreiveCompany(companyID);
	}

	@Override
	public Company retreiveCompanyByName(String companyName) {
		// TODO Auto-generated method stub
		return dao.retreiveCompanyByName(companyName);
	}

	@Override
	public Company retreiveCompanyByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.retreiveCompanyByUsername(username);
	}

	@Override
	public void displayCompanyLogo(String companyID, HttpServletResponse response) {
		// TODO Auto-generated method stub
		dao.displayCompanyLogo(companyID, response);
	}


	@Override
	public void updateCompany(Company company) {
		// TODO Auto-generated method stub
		Company entity = dao.retreiveCompany(company.getCompanyID());
		
		if ( entity != null ) {
			entity.setCompanyID(company.getCompanyID());
			entity.setCompanyName(company.getCompanyName());
			entity.setCity(company.getCity());
			entity.setCompanyLogo(company.getCompanyLogo());
			entity.setCountry(company.getCountry());
			entity.setEmail(company.getEmail());
			entity.setPhoneNumber(company.getPhoneNumber());
			entity.setPostalCode(company.getPostalCode());
			entity.setProvince(company.getProvince());
			
			dao.updateCompany(entity);
		}
	}

	@Override
	public ArrayList<Company> retreiveCompanies() {
		// TODO Auto-generated method stub
		return dao.retreiveCompanies();
	}

	@Override
	public boolean isCompanyIDAlreadyExists(String companyID) {
		// TODO Auto-generated method stub
		
		return dao.isCompanyIDAlreadyExists(companyID);
	}

	@Override
	public boolean isCompanyNameAlreadyExists(String companyName) {
		// TODO Auto-generated method stub
		return dao.isCompanyNameAlreadyExists(companyName);
	}
	

}
