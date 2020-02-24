package com.parking.service;

import java.util.List;

import com.parking.model.Employee;

public interface EmployeeService {
	
	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmployee(Employee employee);
	
	Integer updateEmployee(Employee employee, String email);


	/**
	 * 
	 * @param id
	 * @return
	 */
	Employee getEmployee(String mail);




	/**
	 * 
	 * @return
	 */
	List<Employee> getAllEmployees();
	
	void setEmployeeImage(String emailId, String imageName);
	
	String getEmployeeImage(String emailId);	

}
