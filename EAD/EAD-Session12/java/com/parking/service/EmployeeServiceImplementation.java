package com.parking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.EmployeeDao;
import com.parking.dao.ImageDao;
import com.parking.model.Employee;
import com.parking.model.Image;

/**
 * The Class EmployeeServiceImplementation.
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private ImageDao imageDao;
	
	@Override
	public int addEmployee(Employee employee) {
		Employee emp =  employeeDao.save(employee);
		return emp.getId();
	}

	@Override
	public Integer updateEmployee(Employee employee, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String mail) {
		return employeeDao.findEmployeeByEmailId(mail);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEmployeeImage(Image image) {
		imageDao.save(image);		
	}

	@Override
	public String getEmployeeImage(String emailId) {
		List<Image> img = (List<Image>) imageDao.findAll();
		for( Image i : img) {
			if(i.getEmailId().equals("gh0st@linux.com")) {
				return i.getImageName();
			}
		}
		
		return null;
	}

	@Override
	public Integer getUserId(String emailId) {
		Employee emp = employeeDao.findEmployeeByEmailId(emailId);

		return emp.getId();
	}

	@Override
	public List<Employee> getFirends(String organization, String email) {
		Iterable<Employee> list = employeeDao.findAll();
		ArrayList<Employee> friends = new ArrayList<>();
		for( Employee emp : list ) {
			if( emp.getOrganization().equals(organization) && !(emp.getEmailId().equals(email)) ) {
				friends.add(emp);
			}
		}
		return friends;
	}
}
