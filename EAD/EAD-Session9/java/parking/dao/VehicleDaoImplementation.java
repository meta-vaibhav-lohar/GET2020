package com.parking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.parking.model.Vehicle;

@Repository
public class VehicleDaoImplementation implements VehicleDao {
	
	

	private static HashMap<String, Double[]> setValue() {
		HashMap<String, Double[]> priceCard = new HashMap<String, Double[]>();
		Double[] cycle = { 5.0, 100.0, 500.0 };
		Double[] bike = { 10.0, 200.0, 1000.0 };
		Double[] car = { 20.0, 500.0, 3500.0 };

		priceCard.put("cycle", cycle);
		priceCard.put("bike", bike);
		priceCard.put("car", car);
		return priceCard;
	}

	private static HashMap<String, Double[]> priceCard = setValue();
	
	private Double setPrice(String passType, String vehicleType) {
		Double dollarPerRuppee = 0.014;
		if (passType.equals("Daily"))
			return priceCard.get(vehicleType)[0] * dollarPerRuppee;
		if (passType.equals("Monthly"))
			return  priceCard.get(vehicleType)[1] * dollarPerRuppee;
		if (passType.equals("Yearly"))
			return  priceCard.get(vehicleType)[2] * dollarPerRuppee;
		return null;
	}

	@Override
	public int addVehicle(Vehicle vehicle, Integer userId, String emailId) {

		String name = vehicle.getName();

		String vehicleType = vehicle.getVehicleType();

		String vehicleNumber = vehicle.getVehicleNumber();

		String employeeId = vehicle.getEmployeeId();

		String identification = vehicle.getIdentification();

		String passType = vehicle.getPassType();

		Double price = setPrice(passType, vehicleType);

		Integer vehicleId = null;


		Connection connection = DatabaseConnect.connect();
		String sql = "INSERT INTO vehicles(name, vehicle_type, vehicle_number, employee_id,"
				+ " identification,pass_type,price)" + " VALUES('" + name + "','" + vehicleType + "','" + vehicleNumber
				+ "','" + employeeId + "','" + identification + "','" + passType + "','" + price + "')";
		try {

			Statement stmt = connection.createStatement();

			int result = stmt.executeUpdate(sql);

			if (result == 1) {

				String sql3 = "SELECT id FROM vehicles WHERE employee_id='" + employeeId + "'";
				ResultSet rs2 = stmt.executeQuery(sql3);
				rs2.next();
				vehicleId = rs2.getInt("id");

				String sql4 = "UPDATE Users SET vehicleId=" + vehicleId + " WHERE id=" + userId;
				stmt.executeUpdate(sql4);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return vehicleId;

	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Double[]> getPriceCard() {
		return (HashMap<String, Double[]>) priceCard.clone();
	}

	@Override
	public Vehicle getVehicle(int id) {
		Vehicle vehicle = new Vehicle();

		Connection connection = DatabaseConnect.connect();

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		String sql1 = "SELECT name, vehicle_type,vehicle_number, employee_id,identification,pass_type,price "
				+ "FROM vehicles WHERE id=" + id;
		
		try {
			rs = stmt.executeQuery(sql1);
			
			
			while (rs.next()) {
				vehicle.setName(rs.getString("name"));
				vehicle.setVehicleType(rs.getString("vehicle_type"));
				vehicle.setVehicleNumber(rs.getString("vehicle_number"));
				vehicle.setEmployeeId(rs.getString("employee_id"));
				vehicle.setIdentification(rs.getString("identification"));
				vehicle.setPassType(rs.getString("pass_type"));
				vehicle.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	@Override
	public void updateVehicle(Vehicle vehicle, Integer vehicleId) {
		String name = vehicle.getName();

		String vehicleType = vehicle.getVehicleType();

		String vehicleNumber = vehicle.getVehicleNumber();

		String employeeId = vehicle.getEmployeeId();

		String identification = vehicle.getIdentification();

		String passType = vehicle.getPassType();
		Double price = setPrice(passType, vehicleType);
		
        String sql = "UPDATE VEHICLES SET name='"+name+"', vehicle_type='"+vehicleType+"', vehicle_number='"+vehicleNumber+"', employee_id='"+employeeId+"', identification='"+identification+"', pass_type='"+passType+"', price='"+price+"' WHERE id='"+vehicleId+"'";
        
		Connection connection = DatabaseConnect.connect();

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
