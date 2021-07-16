package com.MyCVOnline.model.dao;

import java.util.ArrayList;

import com.MyCVOnline.model.CompanyEmployee;

public interface CompanyEmployeeDAO {

	public void insertEmployee(CompanyEmployee employee);

	public void deleteEmployee(String username);

	public CompanyEmployee retreiveEmployee(String username);

	public void updateEmployee(CompanyEmployee employee);

	public ArrayList<CompanyEmployee> retreiveEmployees();

}
