package com.parking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parking.model.Employee;
import com.parking.model.Vehicle;

/**
 * The Class VehicleDaoImplementation.
 */
@Repository
public class VehicleDaoImplementation implements VehicleDao {

	@Autowired
	EntityManager entityManager;

	/**
	 * Sets the value.
	 *
	 * @return the hash map
	 */
	private static HashMap<String, Double[]> setValue() {
		HashMap<String, Double[]> priceCard = new HashMap<String, Double[]>();
		Double[] cycle = { 5.0, 100.0, 500.0 };
		Double[] bike = { 10.0, 200.0, 1000.0 };
		Double[] car = { 20.0, 500.0, 3500.0 };

		priceCard.put("cycle", cycle);
		priceCard.put("bike", bike);
		priceCard.put("car", car);
		return priceCard;
	}

	/** The price card. */
	private static HashMap<String, Double[]> priceCard = setValue();

	/**
	 * Sets the price.
	 *
	 * @param passType    the pass type
	 * @param vehicleType the vehicle type
	 * @return the double
	 */
	private Double setPrice(String passType, String vehicleType) {
		Double dollarPerRuppee = 0.014;
		if (passType.equals("Daily"))
			return priceCard.get(vehicleType)[0] * dollarPerRuppee;
		if (passType.equals("Monthly"))
			return priceCard.get(vehicleType)[1] * dollarPerRuppee;
		if (passType.equals("Yearly"))
			return priceCard.get(vehicleType)[2] * dollarPerRuppee;
		return null;
	}

	private int getId(String employeeId) {

		Session currentSession = entityManager.unwrap(Session.class);
		String sql = "SELECT vehicleId FROM Vehicle WHERE employeeId = '" + employeeId + "'";
		Query<Integer> result = currentSession.createQuery(sql, Integer.class);
		return result.getSingleResult();
	}

	/**
	 * Adds the vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param userId  the user id
	 * @param emailId the email id
	 * @return the int
	 */
	@Override
	public int addVehicle(Vehicle vehicle, Integer userId, String emailId) {

		Session currentSession = entityManager.unwrap(Session.class);
		vehicle.setPrice(setPrice(vehicle.getPassType(), vehicle.getVehicleType()));
		currentSession.saveOrUpdate(vehicle);
		Integer vehicleId = getId(vehicle.getEmployeeId());
		Session session = entityManager.unwrap(Session.class);
		String sql = "UPDATE Employee e SET e.vehicleId=" + vehicleId + " WHERE id =" + userId;
		Transaction txn = session.beginTransaction();

		Query query = session.createQuery(sql);
		query.executeUpdate();
		txn.commit();

		return vehicleId;

	}

	/**
	 * Gets the all vehicles.
	 *
	 * @return the all vehicles
	 */
	@Override
	public List<Vehicle> getAllVehicles() {
		return null;
	}

	/**
	 * Gets the price card.
	 *
	 * @return the price card
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Double[]> getPriceCard() {
		return (HashMap<String, Double[]>) priceCard.clone();
	}

	/**
	 * Gets the vehicle.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	@Override
	public Vehicle getVehicle(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Vehicle vehicleObj = currentSession.get(Vehicle.class, id);
		return vehicleObj;
	}

	/**
	 * Update vehicle.
	 *
	 * @param vehicle   the vehicle
	 * @param vehicleId the vehicle id
	 */
	@Override
	public void updateVehicle(Vehicle vehicle, Integer vehicleId) {
		Session session = entityManager.unwrap(Session.class);
		vehicle.setVehicleId(vehicleId);
		session.update(vehicle);

	}
}
