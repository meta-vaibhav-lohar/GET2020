package com.parking.dao;

import java.util.ArrayList;
import java.util.List;

import com.parking.model.Employee;
import com.parking.model.Image;

/**
 * The Interface EmployeeDao.
 */
public interface EmployeeDao {

	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	int addEmployee(Employee employee);

	/**
	 * Gets the empolyee.
	 *
	 * @param mail the mail
	 * @return the empolyee
	 */
	Employee getEmpolyee(String mail);

	/**
	 * Gets the vehicle id.
	 *
	 * @param mail the mail
	 * @return the vehicle id
	 */
	int getVehicleId(String mail);

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	List<Employee> getAllStudents();

	/**
	 * Gets the friends list.
	 *
	 * @param string the string
	 * @param email the email
	 * @return the friends list
	 */
	ArrayList<Employee> getFriendsList(String string, String email);

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

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @param mail the mail
	 * @return the integer
	 */
	Integer updateEmployee(Employee employee, String mail);
}
