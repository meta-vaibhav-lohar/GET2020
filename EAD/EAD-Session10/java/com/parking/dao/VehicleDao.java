package com.parking.dao;

import java.util.List;

import com.parking.model.Vehicle;

/**
 * The Interface VehicleDao.
 */
public interface VehicleDao {

	/**
	 * Adds the vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param userId the user id
	 * @param emailId the email id
	 * @return the int
	 */
	int addVehicle(Vehicle vehicle, Integer userId, String emailId);

	/**
	 * Gets the vehicle.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	Vehicle getVehicle(int id);

	/**
	 * Gets the all vehicles.
	 *
	 * @return the all vehicles
	 */
	public List<Vehicle> getAllVehicles();

	/**
	 * Update vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param vehicleId the vehicle id
	 */
	void updateVehicle(Vehicle vehicle, Integer vehicleId);
}
