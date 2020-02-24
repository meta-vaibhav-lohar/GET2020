package com.parking.service;

import java.util.List;

import javax.validation.Valid;

import com.parking.model.Vehicle;


public interface VehicleService {

	int addVehicle(Vehicle vehicle, Integer userId, String emailId);


	Vehicle getVehicle(int id);


	List<Vehicle> getAllEmployees();


	void updateVehicle(Vehicle vehicle, Integer vehicleId);

}
