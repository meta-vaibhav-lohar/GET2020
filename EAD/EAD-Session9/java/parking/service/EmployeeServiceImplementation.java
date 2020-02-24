package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.EmployeeDao;
import com.parking.model.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public int addEmployee(Employee employee) {
		
		return employeeDao.addEmployee(employee);
		
	}

	@Override
	public Employee getEmployee(String mail) {
		return employeeDao.getEmpolyee(mail);
		 
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setEmployeeImage(String emailId, String imageName) {
		employeeDao.setEmployeeImage(emailId, imageName);
	}
	
	public String getEmployeeImage(String emailId) {
		return employeeDao.getEmployeeImage(emailId);
	}

	@Override
	public Integer updateEmployee(Employee employee, String email) {
		 return employeeDao.updateEmployee(employee,email);
	}
}
