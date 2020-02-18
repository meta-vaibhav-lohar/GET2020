package com.student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * The Class Student.
 */
public class Student {

	/** The id. */
	private Integer id;

	/** The first name. */
	@NotBlank(message = "{empty}")
	private String first_name;

	/** The last name. */
	@NotBlank(message = "{empty}")
	private String last_name;

	/** The father name. */
	@NotBlank(message = "{empty}")
	private String father_name;

	/** The email. */
	@NotBlank(message = "{empty}")
	@Email(message = "{badEmail}")
	private String email;

	/** The student class. */
	@NotBlank(message = "{empty}")
	private String student_class;

	/** The age. */
	private int age;

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * Sets the first name.
	 *
	 * @param first_name the new first name
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * Sets the last name.
	 *
	 * @param last_name the new last name
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * Gets the father name.
	 *
	 * @return the father name
	 */
	public String getFather_name() {
		return father_name;
	}

	/**
	 * Sets the father name.
	 *
	 * @param father_name the new father name
	 */
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the student class.
	 *
	 * @return the student class
	 */
	public String getStudent_class() {
		return student_class;
	}

	/**
	 * Sets the student class.
	 *
	 * @param student_class the new student class
	 */
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
