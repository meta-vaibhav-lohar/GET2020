package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.EmployeeDao;
import com.parking.model.Employee;
import com.parking.model.Image;

/**
 * The Class EmployeeServiceImplementation.
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {

	/** The employee dao. */
	@Autowired
	private EmployeeDao employeeDao;

	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int addEmployee(Employee employee) {

		return employeeDao.addEmployee(employee);

	}

	/**
	 * Gets the employee.
	 *
	 * @param mail the mail
	 * @return the employee
	 */
	@Override
	public Employee getEmployee(String mail) {
		return employeeDao.getEmpolyee(mail);

	}

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Sets the employee image.
	 *
	 * @param emailId the email id
	 * @param imageName the image name
	 */
	public void setEmployeeImage(Image image) {
		employeeDao.setEmployeeImage(image);
	}

	/**
	 * Gets the employee image.
	 *
	 * @param emailId the email id
	 * @return the employee image
	 */
	public String getEmployeeImage(String emailId) {
		return employeeDao.getEmployeeImage(emailId);
	}

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @param email the email
	 * @return the integer
	 */
	@Override
	public Integer updateEmployee(Employee employee, String email) {
		return employeeDao.updateEmployee(employee, email);
	}
}
