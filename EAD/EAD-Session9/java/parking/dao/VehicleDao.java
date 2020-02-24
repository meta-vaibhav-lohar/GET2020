package com.parking.dao;

import java.util.List;

import com.parking.model.Vehicle;

public interface VehicleDao {

	int addVehicle(Vehicle vehicle, Integer userId, String emailId);
	
	Vehicle getVehicle(int id);

	public List<Vehicle> getAllVehicles();

	void updateVehicle(Vehicle vehicle, Integer vehicleId);
}
