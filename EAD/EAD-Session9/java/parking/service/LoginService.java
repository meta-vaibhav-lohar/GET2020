package com.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.LoginDao;
import com.parking.model.LoginDetails;

/**
 * The Class LoginService.
 */
@Service
public class LoginService {

	/** The logindao. */
	@Autowired
	LoginDao logindao;

	/**
	 * Login.
	 *
	 * @param login the login
	 * @return true, if successful
	 */
	public boolean login(LoginDetails login) {

		return logindao.login(login);

	}
}
