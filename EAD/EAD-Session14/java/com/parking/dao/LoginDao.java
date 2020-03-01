package com.parking.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.parking.model.LoginDetails;

/**
 * The Class LoginDao.
 */
@Repository
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

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

			String sql = "SELECT password FROM users WHERE email='" + email + "'";

			try {
			passwordDb = jdbcTemplate.queryForObject(sql, String.class);
			if (password.equals(passwordDb))
				return true;
			}catch(Exception e) {
				return false;

			}

		return false;
	}
}
