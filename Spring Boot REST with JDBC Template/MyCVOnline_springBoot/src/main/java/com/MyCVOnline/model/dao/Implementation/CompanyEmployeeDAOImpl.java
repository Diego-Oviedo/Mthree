package com.MyCVOnline.model.dao.Implementation;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.MyCVOnline.model.CompanyEmployee;
import com.MyCVOnline.model.dao.AbstractDAO;
import com.MyCVOnline.model.dao.CompanyEmployeeDAO;

@Repository("employeeDAO")
public class CompanyEmployeeDAOImpl extends AbstractDAO<CompanyEmployee> implements CompanyEmployeeDAO {

	@Transactional
	public void insertEmployee(CompanyEmployee employee) {
		
		save(employee);

	}

	@Transactional
	public void deleteEmployee(String username) {
		
		Query query = getSession().createQuery("FROM CompanyEmployee WHERE username = :username ");
		query.setParameter("username", username);
		
		CompanyEmployee employee = (CompanyEmployee)query.uniqueResult();
		
		delete(employee);
		

	}

	@Transactional
	public CompanyEmployee retreiveEmployee(String username) {
		
		Query query = getSession().createQuery("FROM CompanyEmployee WHERE username = :username ");
		query.setParameter("username", username);
		
		CompanyEmployee employee = (CompanyEmployee)query.uniqueResult();
		
		return employee;
	}

	@Transactional
	public void updateEmployee(CompanyEmployee employee) {
		
		Query query = getSession().createQuery("UPDATE CompanyEmployee"
												+ "PASSWORD = :password, "
												+ "FISRT_NAME = :firstName, "
												+ "LAST_NAME = :lastName "
												+ "WHERE USERNAME = :username");
		query.setParameter("password", employee.getPassword());
		query.setParameter("firstName", employee.getFirstName());
		query.setParameter("lastName", employee.getLastName());
		query.setParameter("username", employee.getUsername());
		
		query.executeUpdate();

	}

	@Transactional
	public ArrayList<CompanyEmployee> retreiveEmployees() {
		
		Criteria criteria = createEntityCriteria();
		@SuppressWarnings("unchecked")
		ArrayList<CompanyEmployee> all_employees = (ArrayList<CompanyEmployee>) criteria.list();
		
		
		return all_employees;
	}

}
