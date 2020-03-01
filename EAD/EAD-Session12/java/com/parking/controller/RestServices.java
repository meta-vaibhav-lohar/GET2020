package com.parking.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.parking.service.VehicleServiceImplementation;

/**
 * The Class RestServices.
 */
@RestController
public class RestServices {

	@Autowired
	VehicleServiceImplementation vehicleImp;

	@GetMapping("/api/prices")
	public HashMap<String, Double[]> prices() {

		HashMap<String, Double[]> price = vehicleImp.getPriceCard();

		return price;

	}
	

}
