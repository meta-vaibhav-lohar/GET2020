package com.parking.service;

import java.util.List;

import com.parking.model.Employee;
import com.parking.model.Image;

/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {

	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	int addEmployee(Employee employee);

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @param email the email
	 * @return the integer
	 */
	Integer updateEmployee(Employee employee, String email);

	/**
	 * Gets the employee.
	 *
	 * @param mail the mail
	 * @return the employee
	 */
	Employee getEmployee(String mail);

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	List<Employee> getAllEmployees();

	/**
	 * Sets the employee image.
	 *
	 * @param emailId the email id
	 * @param imageName the image name
	 */
	void setEmployeeImage(Image image);

	/**
	 * Gets the employee image.
	 *
	 * @param emailId the email id
	 * @return the employee image
	 */
	String getEmployeeImage(String emailId);

}
