package com.parking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.parking.model.Vehicle;

/**
 * The Interface VehicleDao.
 */
public interface VehicleDao extends CrudRepository<Vehicle, Integer> {

	@Query("from Vehicle where vehicleId = :vehicleId")
	Vehicle findVehicleById(@Param("vehicleId") Integer vehicleId);
	
	@Query("from Vehicle where employeeId = :employeeId")
	Vehicle findVehicleByEmployeeId(@Param("employeeId") String employeeId);
}
