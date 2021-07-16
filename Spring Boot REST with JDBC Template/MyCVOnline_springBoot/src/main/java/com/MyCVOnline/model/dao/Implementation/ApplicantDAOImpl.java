package com.MyCVOnline.model.dao.Implementation;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.query.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.ApplicantDAO;

@Repository("applicantDAO")
public class ApplicantDAOImpl extends AbstractDAO<Applicant> implements ApplicantDAO {

	@Transactional
	public void insertApplicant(Applicant applicant) {

		String ID = applicantIDGenerator();
		
			applicant.setApplicantID(ID);
				save(applicant);

	}
	
	
	
	// This method will handle a creation and a non-unique ID validation.  
	// Logic: If the ID created already exists -> add a digit at the end of the ID 
	public String applicantIDGenerator() {
		
		final String PREFIX = "APCNT"; 
		int APCNT_number = retreiveApplicants().size()+1;
		String digits = null ;
		String ID  = null;
		
		
		if (APCNT_number <= 9) {
			
			digits = "0000";
			
			ID = PREFIX + digits + APCNT_number;
			
			if(isApplicantIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCNT_number+1);
			}
			
			
		}else if (APCNT_number <= 99) {
			
			digits = "000";
			
			ID = PREFIX + digits + APCNT_number;
			
			if(isApplicantIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCNT_number+1);
			}
			
		}else if (APCNT_number <= 999) {
			
			digits = "00";
			
			ID = PREFIX + digits + APCNT_number;
			
			if(isApplicantIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCNT_number+1);
			}
			
			
		}else if (APCNT_number <= 9999) {
			
			digits = "0";
			
			ID = PREFIX + digits + APCNT_number;
			
			if(isApplicantIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCNT_number+1);
			}
			
			
		}else if (APCNT_number >= 10000) {	
			
			ID = PREFIX + APCNT_number;
			
			if(isApplicantIDAlreadyExists(ID)) {
				
				ID = PREFIX + digits + (APCNT_number+1);
			}
			
		}
		
		return ID;
	}
	

	@Transactional
	public void insertApplicantAboutYou(String applicantID, String aboutYou) {
		
		Query query = getSession().createQuery("UPDATE Applicant SET about_you = :aboutYou WHERE applicant_id = :applicantID ");
		query.setParameter("aboutYou", aboutYou);
		query.setParameter("applicantID", applicantID);
		query.executeUpdate();
	
	}

	@Transactional
	public void deleteApplicant(String applicnatID) {
		
		Applicant applicant = (Applicant)getByID(applicnatID);
		
		delete(applicant);
	}

	@Transactional
	public Applicant retreiveApplicant(String applicantID) {
		
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("applicantID", applicantID));
        Applicant applicant =  (Applicant) criteria.uniqueResult();
	
		return applicant;
	}

	@Transactional
	public Applicant retreiveUser(String username) {
		
		Query query = getSession().createQuery("FROM Applicant WHERE username = :username ");
		query.setParameter("username", username);
		
		Applicant applicant = (Applicant)query.uniqueResult();
		
		return applicant;
	}

	@Transactional
	public void updateApplicant(Applicant applicant) {
		
		
		Query query = getSession().createQuery("UPDATE Applicant SET "
				+ "USERNAME = :username, "
				+ "PASSWORD = :password, "
				+ "FIRST_NAME = :firstName, "
				+ "LAST_NAME = :lastName, "
				+ "PROFESSION = :profession, "
				+ "PHONE_NUMBER = :phoneNumber, "
				+ "EMAIL = :email, "
				+ "STREET_ADDRESS = :streetAddress, "
				+ "POSTAL_CODE = :postalCode, "
				+ "CITY = :city, "
				+ "PROVINCE = :province, "
				+ "COUNTRY = :country, "
				+ "ABOUT_YOU = :aboutYou, "
				+ "PROFILE_PICTURE = :profilePicture "
				+ "WHERE applicant_id = :applicantID ");
		query.setParameter("username", applicant.getUsername());
		query.setParameter("password", applicant.getPassword());
		query.setParameter("firstName", applicant.getFirstName());
		query.setParameter("lastName", applicant.getLastName());
		query.setParameter("profession", applicant.getProfession());
		query.setParameter("phoneNumber", applicant.getPhoneNumber());
		query.setParameter("email", applicant.getEmail());
		query.setParameter("streetAddress", applicant.getStreetAddress());
		query.setParameter("postalCode", applicant.getPostalCode());
		query.setParameter("city", applicant.getCity());
		query.setParameter("province", applicant.getProvince());
		query.setParameter("country", applicant.getCountry());
		query.setParameter("aboutYou", applicant.getAboutYou());
		query.setParameter("profilePicture", applicant.getProfilePicture());
		query.setParameter("applicantID", applicant.getApplicantID());
		query.executeUpdate();


	}

	@Transactional
	public void displayApplicantProfilePicture(String applicantID, HttpServletResponse response) {
		System.out.println("Works when calling dao method \n");
		
		InputStream in = null; 
		OutputStream out = null;
		BufferedInputStream bufferIN = null;
		BufferedOutputStream bufferOUT = null;
		Query query = null;
		response.setContentType("image/*");
		
		try {

			out = response.getOutputStream();

			query = getSession().createQuery("FROM Applicant WHERE applicant_id = :applicantID");
			query.setParameter("applicantID", applicantID);

			ResultSet result = (ResultSet) query.list();

			if (result.next()) {

				in = result.getBinaryStream("profile_picture");
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
	public ArrayList<Applicant> retreiveApplicants() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<Applicant> applicants = (ArrayList<Applicant>) criteria.list();
		
		return applicants;
	}
	
	@Transactional
	public boolean isApplicantIDAlreadyExists(String applicantID) {
		// TODO Auto-generated method stub
		Applicant applicant = retreiveApplicant(applicantID);
		
		return (applicant != null);
	}
	
	@Transactional
	public boolean isApplicantUsernameAlreadyExists(String username) {
		// TODO Auto-generated method stub
		Applicant applicant = retreiveUser(username);
		
		return (applicant != null);
	}

}
