package com.parking.model;

import javax.validation.constraints.NotBlank;

/**
 * The Class Vehicle.
 */
public class Vehicle {

	/** The name. */
	@NotBlank
	String name;

	/** The vehicle type. */
	@NotBlank
	String vehicleType;

	/** The vehicle number. */
	@NotBlank
	String vehicleNumber;

	/** The employee id. */
	@NotBlank
	String employeeId;

	/** The identification. */
	@NotBlank
	String identification;
	
	/** The pass type. */
	@NotBlank
	String passType;

	/** The price. */
	Double price;

	/**
	 * Gets the pass type.
	 *
	 * @return the pass type
	 */
	public String getPassType() {
		return passType;
	}

	/**
	 * Sets the pass type.
	 *
	 * @param passType the new pass type
	 */
	public void setPassType(String passType) {
		this.passType = passType;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the vehicle type.
	 *
	 * @return the vehicle type
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * Sets the vehicle type.
	 *
	 * @param vehicleType the new vehicle type
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * Gets the vehicle number.
	 *
	 * @return the vehicle number
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * Sets the vehicle number.
	 *
	 * @param vehicleNumber the new vehicle number
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the identification.
	 *
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * Sets the identification.
	 *
	 * @param identification the new identification
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
