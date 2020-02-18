package com.student.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.dao.StudentDao;
import com.student.model.Student;

/**
 * The Class StudentDaoImplementation.
 */
@Repository
public class StudentDaoImplementation implements StudentDao {

	/** The all student. */
	private static List<Student> allStudent = new ArrayList<Student>();

	/**
	 * Adds the student.
	 *
	 * @param student the student
	 * @return the int
	 */
	@Override
	public int addStudent(Student student) {
		System.out.println("add student DAO");

		System.out.println("i:" + student.getId());
		System.out.println("f:" + student.getFirst_name());
		System.out.println("l:" + student.getLast_name());
		System.out.println("fa:" + student.getFather_name());
		System.out.println("e:" + student.getEmail());
		System.out.println("a:" + student.getAge());
		System.out.println("s:" + student.getStudent_class());

		for (int index = 0; index < allStudent.size(); index++) {
			if (student.getEmail().equals(allStudent.get(index).getEmail())) {
				return allStudent.get(index).getId();
			}
		}
		student.setId(allStudent.size() + 1);

		allStudent.add(student);
		return 0;
	}

	/**
	 * Gets the all students.
	 *
	 * @return the all students
	 */
	@Override
	public List<Student> getAllStudents() {
		return allStudent;
	}

}
