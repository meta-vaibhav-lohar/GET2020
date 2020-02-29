package com.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * The Class Employee.
 */
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Integer id;

	/** The full name. */
	@Column
	@NotBlank(message = "{empty}")
	String fullName;

	/** The gender. */
	@Column
	String gender;

	/** The email id. */
	@NotBlank(message = "{empty}")
	@Column
	@Email(message = "{badMail}")
	String emailId;

	/** The password. */
	@Column
	@NotBlank(message = "{empty}")
	String password;

	/** The contact num. */
	@Column
	@NotBlank(message = "{empty}")
	String contactNum;

	/** The organization. */
	@Column
	@NotBlank(message = "{empty}")
	String organization;

	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vehicle_id", unique = true)
	  
	Vehicle vehicle;
	

	public Integer getId() {
		return id;
	}
	public Integer getVId() {
		return vehicle.getVehicleId();
	}
	public void setVId(Integer vid) {
		vehicle.setVehicleId(vid);
	}
	public Vehicle getVehicleObject() {
		return vehicle;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the contact num.
	 *
	 * @return the contact num
	 */
	public String getContactNum() {
		return contactNum;
	}

	/**
	 * Sets the contact num.
	 *
	 * @param contactNum the new contact num
	 */
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	/**
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", gender=" + gender + ", emailId=" + emailId
				+ ", password=" + password + ", contactNum=" + contactNum + ", organization=" + organization
				+ ", vehicle=" + vehicle + "]";
	}
	
}
