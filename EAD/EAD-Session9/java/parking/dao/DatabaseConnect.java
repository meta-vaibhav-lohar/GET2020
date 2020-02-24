package com.parking.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The Class DatabaseConnect.
 */

public class DatabaseConnect {

	/** The Constant DATABASE_URL. */
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/parking";

	/** The Constant DATABASE_USERNAME. */
	static final String DATABASE_USERNAME = "root";

	/** The Constant DATABASE_PASSWORD. */
	static final String DATABASE_PASSWORD = "root";

	/**
	 * Connect.
	 *
	 * @return the connection
	 */
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			return (con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}