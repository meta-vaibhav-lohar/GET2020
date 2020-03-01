package com.parking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.parking.model.Employee;

/**
 * The Interface EmployeeDao.
 */
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	@Query("from Employee where emailId = :emailId")
	Employee findEmployeeByEmailId(@Param("emailId") String emailId);

}
