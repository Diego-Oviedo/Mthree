package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.dao.implementation.EmployeeDaoDB.EmployeeMapper;
import com.sg.jdbctcomplexexample.entity.Employee;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;

/**
 *
 * @author kylerudy
 */
public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
