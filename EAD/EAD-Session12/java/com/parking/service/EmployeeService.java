package com.parking.service;

import java.util.List;

import com.parking.model.Employee;
import com.parking.model.Image;

/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {


	int addEmployee(Employee employee);
	Integer updateEmployee(Employee employee, String email);

	Employee getEmployee(String mail);


	List<Employee> getAllEmployees();

	void setEmployeeImage(Image image);

	String getEmployeeImage(String emailId);
	
	public Integer getUserId(String emailId);
	
	public List<Employee> getFirends(String organization, String email);

}
