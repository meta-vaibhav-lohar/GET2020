package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;

/**
 * The Interface StudentService.
 */
@Service
public interface StudentService {

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
	List<Student> getAllStudents();

}
