package com.parking.service;

import java.util.List;


import com.parking.model.Vehicle;

/**
 * The Interface VehicleService.
 */
public interface VehicleService {

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
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	List<Vehicle> getAllEmployees();

	/**
	 * Update vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param vehicleId the vehicle id
	 */
	void updateVehicle(Vehicle vehicle, Integer vehicleId);

}
