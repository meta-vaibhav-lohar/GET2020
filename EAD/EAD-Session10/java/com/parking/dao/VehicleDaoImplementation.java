package com.parking.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.parking.model.Vehicle;
import com.parking.model.VehicleMapper;

/**
 * The Class VehicleDaoImplementation.
 */
@Repository
public class VehicleDaoImplementation implements VehicleDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * Sets the value.
	 *
	 * @return the hash map
	 */
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

	/** The price card. */
	private static HashMap<String, Double[]> priceCard = setValue();

	/**
	 * Sets the price.
	 *
	 * @param passType the pass type
	 * @param vehicleType the vehicle type
	 * @return the double
	 */
	private Double setPrice(String passType, String vehicleType) {
		Double dollarPerRuppee = 0.014;
		if (passType.equals("Daily"))
			return priceCard.get(vehicleType)[0] * dollarPerRuppee;
		if (passType.equals("Monthly"))
			return priceCard.get(vehicleType)[1] * dollarPerRuppee;
		if (passType.equals("Yearly"))
			return priceCard.get(vehicleType)[2] * dollarPerRuppee;
		return null;
	}

	/**
	 * Adds the vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param userId the user id
	 * @param emailId the email id
	 * @return the int
	 */
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

		String sql = "INSERT INTO vehicles(name, vehicle_type, vehicle_number, employee_id,"
				+ " identification,pass_type,price)" + " VALUES('" + name + "','" + vehicleType + "','" + vehicleNumber
				+ "','" + employeeId + "','" + identification + "','" + passType + "','" + price + "')";
		int result = jdbcTemplate.update(sql);

			if (result == 1) {

				String sql1 = "SELECT id FROM vehicles WHERE employee_id='" + employeeId + "'";
				vehicleId =  jdbcTemplate.queryForObject(sql1, Integer.class);


				String sql2 = "UPDATE Users SET vehicleId=" + vehicleId + " WHERE id=" + userId;
				jdbcTemplate.update(sql2);

			}
		return vehicleId;

	}

	/**
	 * Gets the all vehicles.
	 *
	 * @return the all vehicles
	 */
	@Override
	public List<Vehicle> getAllVehicles() {
		return null;
	}

	/**
	 * Gets the price card.
	 *
	 * @return the price card
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Double[]> getPriceCard() {
		return (HashMap<String, Double[]>) priceCard.clone();
	}

	/**
	 * Gets the vehicle.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	@Override
	public Vehicle getVehicle(int id) {
		Vehicle vehicle = new Vehicle();

		
		String sql = "SELECT name, vehicle_type,vehicle_number, employee_id,identification,pass_type,price "
				+ "FROM vehicles WHERE id=" + id;
		vehicle = jdbcTemplate.queryForObject(sql,new VehicleMapper());

		return vehicle;
	}

	/**
	 * Update vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param vehicleId the vehicle id
	 */
	@Override
	public void updateVehicle(Vehicle vehicle, Integer vehicleId) {
		String name = vehicle.getName();

		String vehicleType = vehicle.getVehicleType();

		String vehicleNumber = vehicle.getVehicleNumber();

		String employeeId = vehicle.getEmployeeId();

		String identification = vehicle.getIdentification();

		String passType = vehicle.getPassType();
		Double price = setPrice(passType, vehicleType);

		String sql = "UPDATE VEHICLES SET name='" + name + "', vehicle_type='" + vehicleType + "', vehicle_number='"
				+ vehicleNumber + "', employee_id='" + employeeId + "', identification='" + identification
				+ "', pass_type='" + passType + "', price='" + price + "' WHERE id='" + vehicleId + "'";

		jdbcTemplate.update(sql);
	}

}
