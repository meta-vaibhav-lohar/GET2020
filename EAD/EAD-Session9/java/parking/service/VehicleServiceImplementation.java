package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.VehicleDao;
import com.parking.model.Vehicle;

/**
 * The Class VehicleServiceImplementation.
 */
@Service
public class VehicleServiceImplementation implements VehicleService {

	/** The vehicle dao. */
	@Autowired
	VehicleDao vehicleDao;

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
		return vehicleDao.addVehicle(vehicle, userId, emailId);

	}

	/**
	 * Gets the vehicle.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	@Override
	public Vehicle getVehicle(int id) {
		return vehicleDao.getVehicle(id);

	}

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@Override
	public List<Vehicle> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Update vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param vehicleId the vehicle id
	 */
	@Override
	public void updateVehicle(Vehicle vehicle, Integer vehicleId) {
		vehicleDao.updateVehicle(vehicle, vehicleId);
	}

}
