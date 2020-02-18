package com.student.dao;

import java.util.List;

import com.student.model.Student;

/**
 * The Interface StudentDao.
 */
public interface StudentDao {

	/**
	 * Adds the student.
	 *
	 * @param student the student
	 * @return the int
	 */
	int addStudent(Student student);

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	public List<Student> getAllStudents();

}
