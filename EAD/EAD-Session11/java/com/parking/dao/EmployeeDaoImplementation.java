package com.parking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.parking.model.Employee;
import com.parking.model.Image;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {
	@Autowired
	private EntityManager entityManager;

	public ArrayList<Employee> getAllStudents() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		ArrayList<Employee> list = (ArrayList<Employee>) query.getResultList();

		return list;
	}

	private int getId(String mail) {

		Session currentSession = entityManager.unwrap(Session.class);
		String sql = "SELECT id FROM Employee WHERE emailId = '" + mail + "'";
		Query<Integer> result = currentSession.createQuery(sql, Integer.class);
		return result.getSingleResult();
	}

	@Override
	public int addEmployee(Employee employee) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		return getId(employee.getEmailId());

	}

	public Employee getEmpolyee(String mail) {

		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, getId(mail));
		return employeeObj;

	}

	@Override
	public int getVehicleId(String mail) {
		System.out.println(mail);
		Integer userId = getId(mail);
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println("work1");
		Employee employeeObj = currentSession.get(Employee.class, userId);
		System.out.println("work2");
		
		return employeeObj.getVId();
	}

	@Override
	public ArrayList<Employee> getFriendsList(String organization, String email) {

		String sql = "FROM Employee WHERE organization ='" + organization + "' AND emailId != '" + email + "'";
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> result = currentSession.createQuery(sql, Employee.class);
		ArrayList<Employee> friends = (ArrayList<Employee>) result.getResultList();
		return friends;
	}

	@Override
	public void setEmployeeImage(Image image) {

		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println("Set Image: " + image.getImageName());
		System.out.println("Set Image: " + image.getEmailId());
		String checkQuery = "select emailId from Image where emailId = '" + image.getEmailId() + "'";
		Query<String> result = currentSession.createQuery(checkQuery, String.class);
		System.out.println("res: " + result.uniqueResult());
		if (result.uniqueResult() == null) {
			System.out.println("Upload");
			currentSession.saveOrUpdate(image);
		} else {

			String sql = "update image set imageName = '" + image.getImageName() + "'where emailId = '"
					+ image.getEmailId() + "'";
			currentSession.createQuery(sql);
		}

	}

	@Override
	public String getEmployeeImage(String emailId) {
		String imageName = "user-solid.svg";
		Session currentSession = entityManager.unwrap(Session.class);
		String checkQuery = "select imageName from Image where emailId = '" + emailId + "'";
		Query<String> result = currentSession.createQuery(checkQuery, String.class);
		String image_name = result.uniqueResult();

		if(image_name == null) {
			return imageName;
		}
		imageName=image_name;
		return imageName;
	}

	@Override
	public Integer updateEmployee(Employee employee, String mail) {
		Integer userId = getId(mail);
		Session session = entityManager.unwrap(Session.class);
		employee.setId(userId);
		String sql = "UPDATE Employee e SET e.fullName='" + employee.getFullName() + "', e.gender='" + employee.getGender() + "', e.emailId='" + employee.getEmailId()
				+ "', e.contactNum='" + employee.getContactNum() + "', e.organization='" + employee.getOrganization() + "' WHERE id="+ userId;
		session.createQuery(sql).executeUpdate();
		
		String sql1 = "update Image set emailId = '" + employee.getEmailId() + "'where emailId = '"
				+mail+ "'";
		System.out.println("1");
		session.createQuery(sql1);
		System.out.println("update mail : " + mail);
		return getVehicleId(mail);
	}

}
