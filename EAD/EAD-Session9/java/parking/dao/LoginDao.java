package com.parking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.parking.model.LoginDetails;

/**
 * The Class LoginDao.
 */
@Repository
public class LoginDao {

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

		Connection connection = DatabaseConnect.connect();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			String sql = "SELECT password FROM users WHERE email='" + email + "'";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				passwordDb = rs.getString("password");
			}

			if (password.equals(passwordDb))
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
