 package com.parking.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.parking.model.Employee;
import com.parking.model.EmployeeMapper;

/**
 * The Class EmployeeDaoImplementation.
 */
@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int addEmployee(Employee employee) {
		
		String sql = "INSERT INTO users(full_name,email,password,contact,gender,organisation)" + " VALUES ( ?, ?, ?, ?, ?, ?)" ;
		//Employee Add
		jdbcTemplate.update(sql,employee.getFullName(),employee.getEmailId().toLowerCase(),employee.getPassword(),employee.getContactNum(),employee.getGender(), employee.getOrganization());

		Integer userId = null;

		String sql1 = "SELECT id FROM users WHERE email= ?";
		userId = jdbcTemplate.queryForObject(sql1, new Object[]{employee.getEmailId().toLowerCase()}, Integer.class);

		
		
		return userId;
	}

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	@Override
	public List<Employee> getAllStudents() {

		return null;
	}

	/**
	 * Gets the empolyee.
	 *
	 * @param mail the mail
	 * @return the empolyee
	 */
	@Override
	public Employee getEmpolyee(String mail) {
		Employee employee = null;

		String sql = "SELECT full_name,email,contact,gender,organisation FROM users WHERE email= ? ";
		employee = jdbcTemplate.queryForObject(sql, new Object[] {mail.toLowerCase()},new EmployeeMapper());

		
		return employee;
	}

	/**
	 * Gets the friends list.
	 *
	 * @param organization the organization
	 * @param email the email
	 * @return the friends list
	 */
	public ArrayList<Employee> getFriendsList(String organization, String email) {

		ArrayList<Employee> friends = new ArrayList<Employee>();

		String sql = "SELECT full_name,email,contact,gender,organisation FROM users" + " WHERE organisation ='"
				+ organization + "' AND email != '" + email + "'";
		friends = (ArrayList<Employee>) jdbcTemplate.query(sql, new EmployeeMapper());
		return friends;

	}

	/**
	 * Gets the vehicle id.
	 *
	 * @param mail the mail
	 * @return the vehicle id
	 */
	public int getVehicleId(String mail) {

		int vehicleId = 0;
		String sql = "SELECT vehicleId FROM users WHERE email= ?";
		vehicleId = jdbcTemplate.queryForObject(sql, new Object[]{mail.toLowerCase()}, Integer.class);

		return vehicleId;

	}

	/**
	 * Sets the employee image.
	 *
	 * @param emailId the email id
	 * @param imageName the image name
	 */
	public void setEmployeeImage(String emailId, String imageName) {
		String checkQuery = "select count(*) from (select emailId from image where emailId = ?)";
		try{
			jdbcTemplate.queryForObject(checkQuery, new Object[] { emailId.toLowerCase()}, String.class);
			String insert = "update image set imagename = ? where emailId = ?";
			jdbcTemplate.update(insert,imageName, emailId);

		}catch(Exception e) {
			String insert = "insert into image values(?, ?)";
			jdbcTemplate.update(insert,emailId, imageName);
		}
		
	
}
	


	/**
	 * Gets the employee image.
	 *
	 * @param emailId the email id
	 * @return the employee image
	 */
	public String getEmployeeImage(String emailId) {

		String imageName = null ;
		
		String strQuery = "SELECT imagename FROM image where emailId= ?" ;
		try{
			imageName = jdbcTemplate.queryForObject(strQuery, new Object[] { emailId.toLowerCase()}, String.class);
		}catch(Exception e) {
			imageName = "user-solid.svg";
		}

		return imageName;

	}

	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @param mail the mail
	 * @return the integer
	 */
	@Override
	public Integer updateEmployee(Employee employee, String mail) {

		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String emailId = employee.getEmailId().toLowerCase();
		String contactNum = employee.getContactNum();
		String organization = employee.getOrganization();

		String sql = "UPDATE USERS SET full_name='" + fullName + "', gender='" + gender + "', email='" + emailId
				+ "', contact='" + contactNum + "', organisation='" + organization + "' WHERE email='" + mail + "'";
		
		jdbcTemplate.update(sql);
		
		Integer vehicleId = null;

		String sql1 = "SELECT vehicleId FROM users WHERE email='" + mail + "'";
		
		vehicleId = jdbcTemplate.queryForObject(sql1, Integer.class);

		
		String sql2 = "UPDATE image SET emailId='" + emailId + "' WHERE emailId = '" + mail + "'";
		jdbcTemplate.update(sql2);
		return vehicleId;
	}

}
