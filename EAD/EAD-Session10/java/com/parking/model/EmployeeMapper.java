package com.parking.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {
	

		public Employee mapRow(ResultSet rs, int i){

			Employee employee = new Employee();
			try {
				employee.setFullName(rs.getString("full_name"));
				employee.setEmailId(rs.getString("email"));
				employee.setContactNum(rs.getString("contact"));
				employee.setOrganization(rs.getString("organisation"));
				employee.setGender(rs.getString("gender"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return employee;
		
	}
}
