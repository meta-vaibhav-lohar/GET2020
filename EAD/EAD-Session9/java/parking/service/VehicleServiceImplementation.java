package com.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.VehicleDao;
import com.parking.model.Vehicle;
@Service
public class VehicleServiceImplementation implements VehicleService {

	@Autowired
	VehicleDao vehicleDao;
	
	@Override
	public int addVehicle(Vehicle vehicle, Integer userId ,String emailId) {
		return vehicleDao.addVehicle(vehicle,userId,emailId);
		
	}

	@Override
	public Vehicle getVehicle(int id) {
		return vehicleDao.getVehicle(id);
		
	}

	@Override
	public List<Vehicle> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVehicle(Vehicle vehicle, Integer vehicleId) {
		vehicleDao.updateVehicle(vehicle,vehicleId);
	}
 
}
