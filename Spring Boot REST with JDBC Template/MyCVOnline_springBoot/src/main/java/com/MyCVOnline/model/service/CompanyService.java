package com.MyCVOnline.model.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import com.MyCVOnline.model.*;

public interface CompanyService {

	public void insertCompany(Company company);

	public void deleteCompany(String companyID);

	public Company retreiveCompany(String companyID);

	public Company retreiveCompanyByName(String companyName);

	public Company retreiveCompanyByUsername(String username);

	public void displayCompanyLogo(String companyID, HttpServletResponse response);

	public void updateCompany(Company company);

	public ArrayList<Company> retreiveCompanies();

	public boolean isCompanyIDAlreadyExists(String companyID);
	
	public boolean isCompanyNameAlreadyExists(String companyName);

}
