package com.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * The Class LoginDetails.
 */
public class LoginDetails {

	/** The email id. */
	@NotBlank(message = "{empty}")
	@Email(message = "{badMail}")
	String emailId;
	
	/** The password. */
	@NotBlank(message = "{empty}")
	String password;

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

}
