package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.parking.model.Employee;

/**
 * The Class EmployeeDaoImplementation.
 */
@Repository
public class EmployeeDaoImplementation implements EmployeeDao {

	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int addEmployee(Employee employee) {

		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String emailId = employee.getEmailId().toLowerCase();
		String password = employee.getPassword();
		String contactNum = employee.getContactNum();
		String organization = employee.getOrganization();

		Integer userId = null;

		Connection connection = DatabaseConnect.connect();
		String sql = "INSERT INTO users(full_name,email,password,contact,gender,organisation)" + " VALUES " + "('"
				+ fullName + "','" + emailId + "','" + password + "','" + contactNum + "','" + gender + "','"
				+ organization + "')";
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate(sql);

			String sql1 = "SELECT id FROM users WHERE email='" + emailId + "'";
			ResultSet rs2 = stmt.executeQuery(sql1);
			rs2.next();
			userId = rs2.getInt("id");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		Employee employee = new Employee();

		Connection connection = DatabaseConnect.connect();

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		String sql1 = "SELECT full_name,email,contact,gender,organisation FROM users" + " WHERE email= '" + mail + "'";
		try {
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {

				employee.setFullName(rs.getString("full_name"));
				employee.setEmailId(rs.getString("email"));
				employee.setContactNum(rs.getString("contact"));
				employee.setOrganization(rs.getString("organisation"));
				employee.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

		Connection connection = DatabaseConnect.connect();
		ArrayList<Employee> friends = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		String sql1 = "SELECT full_name,email,contact,gender,organisation FROM users" + " WHERE organisation ='"
				+ organization + "' AND email != '" + email + "'";
		try {

			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setFullName(rs.getString("full_name"));
				employee.setEmailId(rs.getString("email"));
				employee.setContactNum(rs.getString("contact"));
				employee.setOrganization(rs.getString("organisation"));
				employee.setGender(rs.getString("gender"));
				friends.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

		Connection connection = DatabaseConnect.connect();
		try {
			Statement stmt = connection.createStatement();

			String sql = "SELECT vehicleId FROM users WHERE email='" + mail + "'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			vehicleId = rs.getInt("vehicleId");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vehicleId;

	}

	/**
	 * Sets the employee image.
	 *
	 * @param emailId the email id
	 * @param imageName the image name
	 */
	public void setEmployeeImage(String emailId, String imageName) {
		Connection connection = DatabaseConnect.connect();

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String checkQuery = "select emailId from image where emailId = '" + emailId + "'";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(checkQuery);
			if (!rs.next()) {
				PreparedStatement insert = connection.prepareStatement("insert into image values(?, ?)");
				insert.setString(1, emailId);
				insert.setString(2, imageName);
				insert.executeUpdate();
			} else {
				PreparedStatement insert = connection
						.prepareStatement("update image set imagename = ? where emailId = '" + emailId + "'");
				insert.setString(1, imageName);
				insert.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the employee image.
	 *
	 * @param emailId the email id
	 * @return the employee image
	 */
	public String getEmployeeImage(String emailId) {

		Connection connection = DatabaseConnect.connect();

		String imageName = "user-solid.svg";
		Statement stmt = null;
		try {
			stmt = connection.createStatement();

			String strQuery = "SELECT imagename FROM image where emailId='" + emailId + "'";
			ResultSet rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				imageName = rs.getString("imagename");
			}
			return imageName;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

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
		System.out.println("Update Employee");
		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String emailId = employee.getEmailId().toLowerCase();
		String contactNum = employee.getContactNum();
		String organization = employee.getOrganization();

		String sql = "UPDATE USERS SET full_name='" + fullName + "', gender='" + gender + "', email='" + emailId
				+ "', contact='" + contactNum + "', organisation='" + organization + "' WHERE email='" + mail + "'";
		String sql2 = "UPDATE image SET emailId='" + emailId + "' WHERE emailId = '" + mail + "'";
		String sql1 = "SELECT vehicleId FROM users WHERE email='" + mail + "'";
		Integer vehicleId = null;
		Connection connection = DatabaseConnect.connect();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			ResultSet rs = stmt.executeQuery(sql1);
			rs.next();
			vehicleId = rs.getInt("vehicleId");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicleId;
	}

}
