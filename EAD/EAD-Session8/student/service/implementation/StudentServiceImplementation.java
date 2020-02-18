package com.student.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.service.StudentService;

/**
 * The Class StudentServiceImplementation.
 */
@Service
public class StudentServiceImplementation implements StudentService {

	/** The student dao. */
	@Autowired
	private StudentDao studentDao;

	/**
	 * Adds the student.
	 *
	 * @param student the student
	 * @return the int
	 */
	@Override
	public int addStudent(Student student) {
		System.out.println("add student service");
		return studentDao.addStudent(student);

	}

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	@Override
	public List<Student> getAllStudents() {

		return studentDao.getAllStudents();
	}

}
