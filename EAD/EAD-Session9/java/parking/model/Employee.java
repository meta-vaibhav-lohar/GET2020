package com.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * The Class Employee.
 */
public class Employee {

	/** The full name. */
	@NotBlank(message = "{empty}")
	String fullName;

	/** The gender. */
	String gender;

	/** The email id. */
	@NotBlank(message = "{empty}")
	@Email(message = "{badMail}")
	String emailId;

	/** The password. */
	@NotBlank(message = "{empty}")
	String password;

	/** The contact num. */
	@NotBlank(message = "{empty}")
	String contactNum;

	/** The organization. */
	@NotBlank(message = "{empty}")
	String organization;

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
}
