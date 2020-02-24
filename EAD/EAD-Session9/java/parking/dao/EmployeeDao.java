package com.parking.dao;

import java.util.ArrayList;
import java.util.List;

import com.parking.model.Employee;

public interface EmployeeDao {

	int addEmployee(Employee employee);
	
	Employee getEmpolyee(String mail);
	
	int getVehicleId(String mail);

	List<Employee> getAllStudents();

	ArrayList<Employee> getFriendsList(String string,String email);
	
	void setEmployeeImage(String emailId, String imageName);
	
	String getEmployeeImage(String emailId);
	
	Integer updateEmployee(Employee employee, String mail);
}
