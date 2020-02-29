package com.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * The Class Vehicle.
 */
@Entity
public class Vehicle {

	/** The name. */
	@NotBlank
	@Column
	String name;

	/** The vehicle type. */
	@NotBlank
	@Column
	String vehicleType;

	/** The vehicle number. */
	@NotBlank
	@Column
	String vehicleNumber;

	/** The employee id. */
	@NotBlank
	String employeeId;

	/** The identification. */
	@NotBlank
	@Column
	String identification;
	
	/** The pass type. */
	@NotBlank
	@Column
	String passType;

	/** The price. */
	@Column
	Double price;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Integer vehicleId;
	
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

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

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber
				+ ", employeeId=" + employeeId + ", identification=" + identification + ", passType=" + passType
				+ ", price=" + price + ", vehicleId=" + vehicleId + "]";
	}
	

}
