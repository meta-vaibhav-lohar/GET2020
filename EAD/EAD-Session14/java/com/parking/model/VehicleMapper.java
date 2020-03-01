package com.parking.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum)  {
		Vehicle vehicle =new Vehicle();
		
		try {
			vehicle.setName(rs.getString("name"));
			vehicle.setVehicleType(rs.getString("vehicle_type"));
			vehicle.setVehicleNumber(rs.getString("vehicle_number"));
			vehicle.setEmployeeId(rs.getString("employee_id"));
			vehicle.setIdentification(rs.getString("identification"));
			vehicle.setPassType(rs.getString("pass_type"));
			vehicle.setPrice(rs.getDouble("price"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehicle;
	}

}
