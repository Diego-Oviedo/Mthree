package com.MyCVOnline.model.dao.Implementation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.Company;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.CompanyDAO;

@Repository("companyDAO")
public class CompanyDAOImpl extends AbstractDAO<Company>  implements CompanyDAO {

	@Transactional
	public void insertCompany(Company company) {
		
		String ID = companyIDGenerator();
		
		company.setCompanyID(ID);
		
		save(company);
	}
	
	
	// This method will handle a creation and a non-unique ID validation.  
	// Logic: If the ID created already exists -> add a digit at the end of the ID 
	public String companyIDGenerator() {
		
		final String PREFIX = "CMPNY"; 
		int CMPNY_number = retreiveCompanies().size()+1;
		String digits = null ;
		String ID  = null;
		
		
		if (CMPNY_number <= 9) {
			
			digits = "0000";
			
			ID = PREFIX + digits + CMPNY_number;
			
			if(isCompanyIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (CMPNY_number+1);
			}
			
			
		}else if (CMPNY_number <= 99) {
			
			digits = "000";
			
			ID = PREFIX + digits + CMPNY_number;
			
			if(isCompanyIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (CMPNY_number+1);
			}
			
		}else if (CMPNY_number <= 999) {
			
			digits = "00";
			
			ID = PREFIX + digits + CMPNY_number;
			
			if(isCompanyIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (CMPNY_number+1);
			}
			
			
		}else if (CMPNY_number <= 9999) {
			
			digits = "0";
			
			ID = PREFIX + digits + CMPNY_number;
			
			if(isCompanyIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (CMPNY_number+1);
			}
			
			
		}else if (CMPNY_number >= 10000) {	
			
			ID = PREFIX + CMPNY_number;
			
			if(isCompanyIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (CMPNY_number+1);
			}
			
		}
		
		return ID;
	}

	@Transactional
	public void deleteCompany(String companyID) {
		
		Company company = (Company)getByID(companyID);

			delete(company);
		
	}

	@Transactional
	public Company retreiveCompany(String companyID) {
		
		Company company = (Company)getByID(companyID);
		
		return company;
	}

	@Transactional
	public Company retreiveCompanyByName(String companyName) {
		
		Query query = getSession().createQuery("FROM COMPANIES WHERE company_name = :companyName ");
		query.setParameter("companyName", companyName);
		
		Company company = (Company)query.uniqueResult();
		
		return company;
	}

	@Transactional
	public Company retreiveCompanyByUsername(String username) {
		
		Query query = getSession().createQuery("FROM COMPANIES WHERE company_id IN (company_id FROM COMPANIES_EMPLOYEES WHERE username = :username )");
		query.setParameter("username", username);
		
		Company company = (Company)query.uniqueResult();
		
		return company;
	}

	@Transactional
	public void displayCompanyLogo(String companyID, HttpServletResponse response) {
		InputStream in = null; 
		OutputStream out = null;
		BufferedInputStream bufferIN = null;
		BufferedOutputStream bufferOUT = null;
		Query query = null;
		response.setContentType("image/*");
		
		try {

			out = response.getOutputStream();

			query = getSession().createQuery("FROM COMPANIES WHERE company_id = :companyID");
			query.setParameter("applicantID", companyID);

			ResultSet result = (ResultSet) query.list();

			if (result.next()) {

				in = result.getBinaryStream("company_logo");
			} else {
				System.out.println("No picture on record");
				getSession().close();
			}

			bufferIN = new BufferedInputStream(in);
			bufferOUT = new BufferedOutputStream(out);

			int i = 0;

			while ((i = bufferIN.read()) != -1) {

				bufferOUT.write(i);
			}

			getSession().close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Transactional
	public void updateCompany(Company company) {
		
		Query query = getSession().createQuery("UPDATE COMPANIES SET"
				+ "COMPANY_NAME = :companyName,"
				+ "PHONE_NUMBER = :phoneNumber,"
				+ "EMAIL = :email,"
				+ "CITY = :city,"
				+ "POSTAL_CODE = :postalCode,"
				+ "PROVINCE = :province,"
				+ "COUNTRY = :country,"
				+ "COMPANY_LOGO = :companyLogo,"
				+ "WHERE company_id = :companyID ");
		query.setParameter("companyName", company.getCompanyName());
		query.setParameter("phoneNumber", company.getPhoneNumber());
		query.setParameter("email", company.getEmail());
		query.setParameter("city", company.getCity());
		query.setParameter("postalCode", company.getPostalCode());
		query.setParameter("province", company.getProvince());
		query.setParameter("country", company.getCountry());
		query.setParameter("companyLogo", company.getCompanyLogo());
		query.setParameter("companyID", company.getCompanyID());
		
		query.executeUpdate();

	}

	@Transactional
	public ArrayList<Company> retreiveCompanies() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<Company> company = (ArrayList<Company>) criteria.list();
		
		return company;
	}
	
	@Transactional
	public boolean isCompanyIDAlreadyExists(String companyID) {
		// TODO Auto-generated method stub
		Company company = (Company)getByID(companyID);
		
		return (company != null);
	}


	@Transactional
	public boolean isCompanyNameAlreadyExists(String companyName) {
		// TODO Auto-generated method stub
		Company company = retreiveCompanyByName(companyName);
		
		return (company != null);
	}
}
