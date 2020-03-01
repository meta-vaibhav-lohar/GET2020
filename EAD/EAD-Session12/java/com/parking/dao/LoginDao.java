package com.parking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parking.model.LoginDetails;

/**
 * The Class LoginDao.
 */
@Repository
public class LoginDao {
	@Autowired
	EntityManager entityManager;

	/**
	 * Login.
	 *
	 * @param login the login
	 * @return true, if successful
	 */
	public boolean login(LoginDetails login) {

		String email = login.getEmailId();
		String password = login.getPassword();

		String passwordDb = null;

			String sql = "SELECT password FROM Employee WHERE emailId='" + email + "'";

			Session currentSession = entityManager.unwrap(Session.class);
			Query<String> result = currentSession.createQuery(sql, String.class);
			passwordDb = result.getSingleResult();

			if (password.equals(passwordDb))
				return true;

		return false;
	}
}
