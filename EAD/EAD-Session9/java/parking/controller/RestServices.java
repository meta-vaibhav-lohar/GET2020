package com.parking.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.parking.dao.EmployeeDaoImplementation;
import com.parking.dao.VehicleDaoImplementation;


@RestController
public class RestServices {
	
	@Autowired
	EmployeeDaoImplementation employeeDao;
	
	@Autowired
	VehicleDaoImplementation vehicleDao;
	
	@GetMapping("/api/prices")
	public HashMap<String, Double[]> prices(){
		
		
		HashMap<String, Double[]> price =  vehicleDao.getPriceCard();
		
		return price;
		
	}
	

}
