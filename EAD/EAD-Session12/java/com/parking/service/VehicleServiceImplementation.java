package com.parking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.EmployeeDao;
import com.parking.dao.VehicleDao;
import com.parking.model.Employee;
import com.parking.model.Vehicle;

/**
 * The Class VehicleServiceImplementation.
 */
@Service
public class VehicleServiceImplementation implements VehicleService {

	/** The vehicle dao. */
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	EntityManager entityManager;

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
			return priceCard.get(vehicleType)[1] * dollarPerRuppee;
		if (passType.equals("Yearly"))
			return priceCard.get(vehicleType)[2] * dollarPerRuppee;
		return null;
	}
	
	@Override
	public int addVehicle(Vehicle vehicle, Integer userId, String emailId, Employee emp) {
		
		vehicle.setPrice(setPrice(vehicle.getPassType(), vehicle.getVehicleType()));
		vehicleDao.save(vehicle);
		Vehicle veh = vehicleDao.findVehicleByEmployeeId(vehicle.getEmployeeId());
		
		Integer vehicleId = veh.getVehicleId();
		
		Employee employee = employeeDao.findEmployeeByEmailId(emailId);
		employee.setVId(vehicleId);
		employeeDao.save(employee);
		
		return vehicleId;


	}

	@Override
	public Vehicle getVehicle(int id) {
		return vehicleDao.findVehicleById(id);
	}

	@Override
	public List<Vehicle> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVehicle(Vehicle vehicle, Integer vehicleId) {
		vehicle.setVehicleId(vehicleId);
		vehicleDao.save(vehicle);
	}
	@SuppressWarnings("unchecked")
	public HashMap<String, Double[]> getPriceCard() {
		return (HashMap<String, Double[]>) priceCard.clone();
	}
}
