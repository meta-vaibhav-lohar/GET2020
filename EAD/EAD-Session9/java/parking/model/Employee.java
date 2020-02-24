package com.parking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Employee {

	@NotBlank(message = "{empty}")
	String fullName;
		
	String gender;
	
	@NotBlank(message = "{empty}")
	@Email(message = "{badMail}")
	String emailId;
	
	@NotBlank(message = "{empty}")
	String password;
	
	@NotBlank(message = "{empty}")
	String contactNum;
	
	@NotBlank(message = "{empty}")
	String organization;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
